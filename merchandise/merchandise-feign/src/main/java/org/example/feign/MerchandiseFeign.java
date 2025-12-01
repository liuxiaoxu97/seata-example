package org.example.feign;

import org.example.params.ReduceParam;
import org.example.response.ResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 *
 * @author LXZ 2025/11/24 17:31
 */
//@FeignClient(value = "merchandise-service" , url = "${feign.client.merchandise-service.url}")
@FeignClient(value = "merchandise-api" , contextId = "MerchandiseFeign", path = "api/m/merchandise")
public interface MerchandiseFeign {


    /**
     *
     * 减少库存接口
     */
    @RequestMapping(value = "/reduce" , method = RequestMethod.POST)
    ResponseModel<Boolean> reduce(@RequestBody ReduceParam reduceParam) ;


    /**
     *
     * 减少库存接口
     */
    @RequestMapping(value = "/reduce/tcc" , method = RequestMethod.POST)
    ResponseModel<Boolean> reduceTcc(@RequestBody ReduceParam reduceParam) ;
}
