package org.example.order.server;

import org.example.feign.params.SubmitParam;

/**
 *
 * 订单服务
 *
 * @author LXZ 2025/11/24 17:20
 */
public interface OrderService {

    /**
     * 下单接口
     */
    Boolean submit(SubmitParam param) ;

}
