package org.example.feifn;

import org.example.feifn.params.SubmitParam;
import org.example.response.ResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author LXZ 2024/11/19 15:54
 */
@FeignClient(name = "order-service" , url = "http://localhost:7102")
public interface OrderApiFeign {

    /**
     * 下单接口
     */
    @RequestMapping(value = "/submit" , method = RequestMethod.POST)
    ResponseModel<Boolean> submit(@RequestBody SubmitParam submitParam) ;

}
