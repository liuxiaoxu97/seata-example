package org.example.user.server.impl;

import org.example.feign.params.UpdateUserDataParam;
import org.example.user.server.UserServer;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author LXZ 2025/11/24 15:46
 */
@Service
public class UserServerImpl implements UserServer {
    /**
     * 更新用户信息
     *
     * @param updateUserDataParam 更新用户信息参数
     */
    @Override
    public Boolean updateUser(UpdateUserDataParam updateUserDataParam) {

        return null;
    }
}
