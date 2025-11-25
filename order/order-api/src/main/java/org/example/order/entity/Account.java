package org.example.order.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 *
 *
 * @author LXZ 2025/11/24 17:17
 */
@Data
@Entity
@Table(name = "account")
public class Account {

    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 订单号
     */
    private String accountNo;
    /**
     * 金额
     */
    private Integer money;
    /**
     * 预付金额
     */
    private Integer preMoney;
    /**
     * 创建时间
     */
    private Date createAt;
    /**
     * 更新时间
     */
    private Date updateAt;
}
