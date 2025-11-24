package org.example.feign;

import org.example.feign.params.UpdateUserDataParam;
import org.example.response.ResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author LXZ 2024/11/19 15:54
 */
@FeignClient(name = "user-service" , url = "http://localhost:8081")
public interface UserApiFeign {


    /**
     * 更新用户信息
     */
    @RequestMapping(value = "/update" , method = RequestMethod.PUT)
    ResponseModel<Boolean> updateUser(@RequestParam(value = "id") UpdateUserDataParam updateUserDataParam) ;

}
