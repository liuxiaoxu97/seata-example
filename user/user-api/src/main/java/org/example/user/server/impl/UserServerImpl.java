package org.example.user.server.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.feign.params.UpdateUserDataParam;
import org.example.user.entity.User;
import org.example.user.repository.UserRepository;
import org.example.user.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.JpaQueryCreator;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author LXZ 2025/11/24 15:46
 */
@Service
@RequiredArgsConstructor
public class UserServerImpl implements UserServer {

    private final JPAQueryFactory jpaQueryFactory;
    private final UserRepository userRepository;

    /**
     * 更新用户信息
     *
     * @param updateUserDataParam 更新用户信息参数
     */
    @Override
    public Boolean updateUser(UpdateUserDataParam updateUserDataParam) {
        User user = new User();
        user.setAge(20);
        user.setName("你好");
        user.setScore(100);
        userRepository.save(user);
        return true;
    }
}
