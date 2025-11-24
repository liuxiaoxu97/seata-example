package org.example.user.api;

import org.example.feign.UserApiFeign;
import org.example.feign.params.UpdateUserDataParam;
import org.example.response.ResponseModel;
import org.example.user.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * 用户信息
 *
 * @author LXZ 2025/11/24 15:28
 */
@RestController
@RequestMapping("/user")
public class UserApi implements UserApiFeign {

    @Autowired
    private UserServer userServer;

    /**
     * 更新用户信息
     *
     * @param updateUserDataParam 更新用户信息参数
     */
    @Override
    @RequestMapping("/update")
    public ResponseModel<Boolean> updateUser(UpdateUserDataParam updateUserDataParam) {
        return null;
    }
}
