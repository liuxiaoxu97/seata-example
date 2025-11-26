package org.example.order.server.impl;

import lombok.RequiredArgsConstructor;
import org.example.feign.params.SubmitParam;
import org.example.order.entity.Account;
import org.example.order.repository.AccountRepository;
import org.example.order.server.OrderService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

/**
 *
 *
 * @author LXZ 2025/11/24 17:28
 */
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final AccountRepository accountRepository;

    /**
     * 下单接口
     *
     * @param param
     */
    @Override
    public Boolean submit(SubmitParam param) {
        Account byAccountNo = accountRepository.findByAccountNo(param.getAccountNo());

        if (Objects.isNull(byAccountNo)) {
            byAccountNo = new Account();
            byAccountNo.setAccountNo(param.getAccountNo());
            byAccountNo.setMoney(param.getMoney());
            byAccountNo.setCreateAt(new Date());
        } else {
            byAccountNo.setMoney(byAccountNo.getMoney() + param.getMoney());
            byAccountNo.setUpdateAt(new Date());
        }
        accountRepository.save(byAccountNo);
        return true;
    }
}
