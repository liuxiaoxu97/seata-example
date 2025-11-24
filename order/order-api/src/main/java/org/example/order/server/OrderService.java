package org.example.order.server;

import org.example.feifn.params.SubmitParam;
import org.example.response.ResponseModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
