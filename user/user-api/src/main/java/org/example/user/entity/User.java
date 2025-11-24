package org.example.user.entity;

import lombok.Data;

import javax.persistence.*;

/**
 *
 * 用户
 *
 * @author LXZ 2025/11/24 15:38
 */
@Data
@Entity
@Table(name = "user")
public class User {

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
