package org.example.feign;

import org.example.feign.params.SubmitParam;
import org.example.response.ResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author LXZ 2024/11/19 15:54
 */
@FeignClient(name = "order-service" , url = "${feign.client.order-service.url}")
public interface OrderApiFeign {

    /**
     * 下单接口
     */
    @RequestMapping(value = "/o/submit" , method = RequestMethod.POST)
    ResponseModel<Boolean> submit(@RequestBody SubmitParam submitParam) ;

}
