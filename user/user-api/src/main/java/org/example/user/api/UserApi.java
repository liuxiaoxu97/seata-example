package org.example.user.api;

import org.example.feign.UserApiFeign;
import org.example.feign.params.UpdateUserDataParam;
import org.example.response.ResponseModel;
import org.example.user.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * 用户信息
 *
 * @author LXZ 2025/11/24 15:28
 */
@RestController
@RequestMapping("/u")
public class UserApi implements UserApiFeign {

    @Autowired
    private UserService userService;

    /**
     * 更新用户信息
     *
     * @param updateUserDataParam 更新用户信息参数
     */
    @Override
    @RequestMapping(value = "/update" , method = RequestMethod.POST)
    public ResponseModel<Boolean> updateUser(@RequestBody UpdateUserDataParam updateUserDataParam) {
        userService.updateUser(updateUserDataParam);
        return ResponseModel.success(true);
    }
}
