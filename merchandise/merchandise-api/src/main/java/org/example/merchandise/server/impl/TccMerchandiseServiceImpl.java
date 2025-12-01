package org.example.merchandise.server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.merchandise.entity.Merchandise;
import org.example.merchandise.mapper.MerchandiseMapper;
import org.example.merchandise.server.MerchandiseService;
import org.example.merchandise.server.TccMerchandiseService;
import org.example.params.ReduceParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 *
 *
 * @author LXZ 2025/11/29 19:01
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class TccMerchandiseServiceImpl extends ServiceImpl<MerchandiseMapper, Merchandise> implements TccMerchandiseService {

private final Map<String ,Boolean> tryStatus = new ConcurrentHashMap<>();


    @Override
    public boolean prepare(BusinessActionContext actionContext, Long id, Integer num) {

        String xid = actionContext.getXid();
        String branchId = String.valueOf(actionContext.getBranchId());
        String key = xid + ":" + branchId;

        log.info("TCC try - 商品减库存 ， merchandiseId:{}, num:{}" , id, num);

        try {

            if (!tryStatus.containsKey(key)) {

                Merchandise merchandise = lambdaQuery().eq(Merchandise::getId, id).one();

                if (ObjectUtils.isEmpty(merchandise)) {
                    throw new RuntimeException("商品不存在");
                }
                lambdaUpdate().eq(Merchandise::getId, id)
                        .set(Merchandise::getPreNumber, num)
                        .set(Merchandise::getUpdateAt, new Date())
                        .update();



                tryStatus.put(key, true);
                return true;
            }
            return false;
        } catch (Exception e) {
            log.error("TCC prepare 商品减库存失败，merchandiseId:{}, num:{}", id, num, e);
            throw new RuntimeException("TCC prepare 商品减库存失败");
        }
    }

    @Override
    public boolean commit(BusinessActionContext actionContext) {

        String xid = actionContext.getXid();
        String branchId = String.valueOf(actionContext.getBranchId());
        String key = xid + ":" + branchId;

        Integer merchandiseId = (Integer) actionContext.getActionContext("id");
        Integer num = (Integer) actionContext.getActionContext("num");

        log.info("TCC commit - 商品减库存提交，merchandiseId:{}, num:{}", merchandiseId, num);
        try {

            if (!tryStatus.containsKey(key)) {
                return true;
            }

            Merchandise merchandise = lambdaQuery().eq(Merchandise::getId, merchandiseId).one();
            if (ObjectUtils.isEmpty(merchandise)) {
                throw new RuntimeException("商品不存在");
            }
            lambdaUpdate().eq(Merchandise::getId, merchandiseId)
                    .set(Merchandise::getNumber, merchandise.getNumber() + num)
                    .set(Merchandise::getPreNumber, null)
                    .set(Merchandise::getUpdateAt, new Date())
                    .update();
            tryStatus.remove(key);
            return true;
        } catch (Exception e) {
            log.error("TCC commit 商品减库存失败，merchandiseId:{}, num:{}", merchandiseId, num, e);
            throw new RuntimeException("TCC commit 商品减库存失败");
        }
    }

    @Override
    public boolean rollback(BusinessActionContext actionContext) {

        String xid = actionContext.getXid();
        String branchId = String.valueOf(actionContext.getBranchId());
        String key = xid + ":" + branchId;

        Integer merchandiseId = (Integer) actionContext.getActionContext("id");
        Integer num = (Integer) actionContext.getActionContext("num");
        log.info("TCC rollback - 商品减库存回滚，merchandiseId:{}, num:{}", merchandiseId, num);
        try {

            if (!tryStatus.containsKey(key)) {
                return true;
            }

            Merchandise merchandise = lambdaQuery().eq(Merchandise::getId, merchandiseId).one();
            if (ObjectUtils.isEmpty(merchandise)) {
                throw new RuntimeException("商品不存在");
            }
            lambdaUpdate().eq(Merchandise::getId, merchandiseId)
                    .set(Merchandise::getPreNumber, null)
                    .set(Merchandise::getUpdateAt, null)
                    .update();

            tryStatus.remove(key);
            return true;
        } catch (Exception e) {
            log.error("TCC rollback 商品减库存失败，merchandiseId:{}, num:{}", merchandiseId, num, e);
            throw new RuntimeException("TCC rollback 商品减库存失败");
        }
    }
}
