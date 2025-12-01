package org.example.at.service;

import org.example.at.params.AtParam;
import org.example.params.ReduceParam;
import org.example.response.ResponseModel;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 *
 * @author LXZ 2025/11/25 16:59
 */
public interface SeataAtService {

    /**
     * at模拟下单接口
     *
     * @param  atParam 订单参数
     * @return 订单是否成功
     */
    Boolean atOrder(AtParam atParam);

    /**
     * tcc模拟下单接口
     *
     * @param  atParam 订单参数
     * @return 订单是否成功
     */
    Boolean tccOrder(AtParam atParam);
}
