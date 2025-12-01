package org.example.user.server.impl;

import org.example.feign.params.UpdateUserDataParam;
import org.example.user.entity.UserEntity;
import org.example.user.repository.UserRepository;
import org.example.user.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 *
 *
 * @author LXZ 2025/11/24 15:46
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    /**
     * 更新用户信息
     *
     * @param updateUserDataParam 更新用户信息参数
     */
    @Override
    public Boolean updateUser(UpdateUserDataParam updateUserDataParam) {
        UserEntity user = userRepository.findById(updateUserDataParam.getUserId()).orElse(null);
        if (ObjectUtils.isEmpty(user)) {
            user = new UserEntity();
            user.setAge(20);
            user.setName("你好");
            user.setScore(100);
        }
        user.setScore(user.getScore() + updateUserDataParam.getScore());
        userRepository.save(user);
        return true;
    }
}
