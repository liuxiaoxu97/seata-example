package org.example.order.server.impl;

import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import org.example.order.entity.Account;
import org.example.order.repository.AccountRepository;
import org.example.order.server.TccOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 *
 * @author LXZ 2025/11/29 18:43
 */
@Service
@Slf4j
public class TccOrderServiceImpl implements TccOrderService {

    @Autowired
    private AccountRepository accountRepository;

    private final Map<String , Boolean > tryStatus = new ConcurrentHashMap<>();

    @Override
    public boolean prepare(BusinessActionContext actionContext, String accountNo, Integer money) {
        log.info("TCC  Try 阶段 - 账户余额扣减 ， accountNo:{}, money:{}" , accountNo, money);
        String xid = actionContext.getXid();
        String branchId = String.valueOf(actionContext.getBranchId());
        String key = xid + ":" + branchId;

        try{
            // 防止空挂
            if (!isCanceled(xid , branchId)) {
                Account byAccountNo = accountRepository.findByAccountNo(accountNo);
                if (ObjectUtils.isEmpty(byAccountNo)) {
                    throw new RuntimeException("账户不存在");
                }

                // 冻结账户余额
                byAccountNo.setPreMoney(money);
                byAccountNo.setUpdateAt(new Date());
                accountRepository.save(byAccountNo);

                log.info("TCC  Try 阶段 - 账户余额增加成功， accountNo:{}, money:{}", accountNo, money);

                tryStatus.put(key, true);
                return true;
            }
            return false;
        }catch (Exception e){
            log.error("TCC  Try 阶段 - 账户余额增加失败， accountNo:{}, money:{}" , accountNo, money, e);
            throw new RuntimeException("账户余额增加失败");
        }
    }

    @Override
    public boolean commit(BusinessActionContext actionContext) {

        String xid = actionContext.getXid();
        String branchId = String.valueOf(actionContext.getBranchId());
        String key = xid + ":" + branchId;
        if (!tryStatus.containsKey(key)) {
            return true;
        }

        String accountNo = Objects.requireNonNull(actionContext.getActionContext("accountNo")).toString();
        Integer money = Integer.parseInt(actionContext.getActionContext("money").toString());
        log.info("TCC  Confirm(确认) 阶段 - 账户余额提交， accountNo:{}, money:{}" , accountNo, money);
        try {
            Account byAccountNo = accountRepository.findByAccountNo(accountNo);
            if (ObjectUtils.isEmpty(byAccountNo)) {
                throw new RuntimeException("账户不存在");
            }
            // 增加账户余额
            byAccountNo.setMoney(byAccountNo.getMoney() + money );
            byAccountNo.setPreMoney(null);
            byAccountNo.setUpdateAt(new Date());
            accountRepository.save(byAccountNo);

            tryStatus.remove(key);
            log.info("TCC  Confirm(确认) 阶段 - 账户余额提交成功， accountNo:{}, money:{}" , accountNo, money);
            return true;
        } catch (Exception e) {
            log.error("TCC  Confirm(确认) 阶段 - 账户余额提交失败， accountNo:{}, money:{}" , accountNo, money, e);
            throw new RuntimeException("账户余额提交失败");
        }
    }

    @Override
    public boolean rollback(BusinessActionContext actionContext) {

        String xid = actionContext.getXid();
        String branchId = String.valueOf(actionContext.getBranchId());
        String key = xid + ":" + branchId;
        if (!tryStatus.containsKey(key)) {
            return true;
        }

        String accountNo = actionContext.getActionContext("accountNo").toString();
        Integer money = Integer.parseInt(actionContext.getActionContext("money").toString());
        log.info("TCC  Confirm(确认) 阶段 - 账户余额回滚， accountNo:{}, money:{}" , accountNo, money);
        try {
            Account byAccountNo = accountRepository.findByAccountNo(accountNo);
            if (ObjectUtils.isEmpty(byAccountNo)) {
                throw new RuntimeException("账户不存在");
            }
            // 增加账户余额
            byAccountNo.setPreMoney(null);
            byAccountNo.setUpdateAt(new Date());
            accountRepository.save(byAccountNo);
            tryStatus.remove(key);
            log.info("TCC  Confirm(确认) 阶段 - 账户余额回滚成功， accountNo:{}, money:{}" , accountNo, money);
            return true;
        } catch (Exception e) {
            log.error("TCC  Confirm(确认) 阶段 - 账户余额回滚失败， accountNo:{}, money:{}" , accountNo, money, e);
            throw new RuntimeException("账户余额回滚失败");
        }
    }

    private boolean isCanceled(String xid, String branchId) {
        return tryStatus.containsKey(xid+branchId); // 简化实现
    }
}
