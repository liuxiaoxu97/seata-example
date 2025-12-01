package org.example.order.api;

import org.example.feign.OrderApiFeign;
import org.example.feign.params.SubmitParam;
import org.example.order.server.OrderService;
import org.example.order.server.TccOrderService;
import org.example.response.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * 订单
 *
 * @author LXZ 2025/11/24 17:16
 */
@RestController
@RequestMapping("/o")
public class OrderApi implements OrderApiFeign {

    @Autowired
    private OrderService orderService;
    @Autowired
    private TccOrderService tccOrderService;

    /**
     * 下单接口
     *
     * @param param 下单参数
     */
    @Override
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public ResponseModel<Boolean> submit(@RequestBody SubmitParam param) {
        orderService.submit(param);
        return ResponseModel.success(true);
    }

    /**
     * 下单接口 TCC模式
     *
     * @param submitParam
     */
    @Override
    @RequestMapping(value = "/submit/tcc", method = RequestMethod.POST)
    public ResponseModel<Boolean> submitTcc(@RequestBody SubmitParam submitParam) {
        tccOrderService.prepare(null , submitParam.getAccountNo() , submitParam.getMoney());
        return ResponseModel.success(true);
    }
}
