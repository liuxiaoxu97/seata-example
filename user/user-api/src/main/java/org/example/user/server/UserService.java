package org.example.user.server;

import org.example.feign.params.UpdateUserDataParam;

/**
 *
 * 用户信息
 *
 * @author LXZ 2025/11/24 15:44
 */
public interface UserService {

    /**
     * 更新用户信息
     *
     * @param updateUserDataParam 更新用户信息参数
     */
    Boolean updateUser(UpdateUserDataParam updateUserDataParam);
}
