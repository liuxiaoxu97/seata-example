package org.example.at.service.impl;

import io.seata.spring.annotation.GlobalTransactional;
import org.example.at.params.AtParam;
import org.example.at.service.SeataAtService;
import org.example.feign.MerchandiseFeign;
import org.example.feign.OrderApiFeign;
import org.example.feign.params.SubmitParam;
import org.example.feign.UserApiFeign;
import org.example.feign.params.UpdateUserDataParam;
import org.example.params.ReduceParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author LXZ 2025/11/25 17:01
 */
@Service
public class SeataAtServiceImpl implements SeataAtService {

    @Autowired
    UserApiFeign userApiFeign;
    @Autowired
    OrderApiFeign orderApiFeign;
    @Autowired
    MerchandiseFeign merchandiseFeign;

    /**
     * 模拟下单接口
     */
    @Override
    @GlobalTransactional
    public Boolean atOrder(AtParam atParam) {

        // 1. 付钱
        SubmitParam submitParam = new SubmitParam();
        submitParam.setAccountNo(atParam.getAccountNo());
        submitParam.setMoney(atParam.getMoney());
        orderApiFeign.submit(submitParam);
        // 2. 减库存
        ReduceParam reduceParam = new ReduceParam();
        reduceParam.setId(1L);
        reduceParam.setNum(atParam.getNum());
        merchandiseFeign.reduce(reduceParam);
        // 3. 加积分
        UpdateUserDataParam updateUserDataParam = new UpdateUserDataParam();
        updateUserDataParam.setUserId(1L);
        updateUserDataParam.setScore(atParam.getScore());
        userApiFeign.updateUser(updateUserDataParam);


        if (1 == 1) {
            throw new RuntimeException("模拟异常");
        }
        return true;
    }
}
