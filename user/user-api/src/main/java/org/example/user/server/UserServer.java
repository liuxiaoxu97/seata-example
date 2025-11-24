package org.example.user.server;

import org.example.feign.params.UpdateUserDataParam;
import org.example.response.ResponseModel;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * 用户信息
 *
 * @author LXZ 2025/11/24 15:44
 */
public interface UserServer {

    /**
     * 更新用户信息
     *
     * @param updateUserDataParam 更新用户信息参数
     */
    Boolean updateUser(UpdateUserDataParam updateUserDataParam);
}
