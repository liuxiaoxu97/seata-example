package org.example.user.entity;

import lombok.Data;

import javax.persistence.*;

/**
 *
 *
 * @author LXZ 2025/11/25 10:47
 */
@Data
@Entity
@Table(name = "user")
public class UserEntity {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 积分
     */
    private Integer score;
}
