package org.example.at.params;

import lombok.Data;

/**
 *
 *
 * @author LXZ 2025/11/25 17:05
 */
@Data
public class AtParam {

    /**
     * 账户号
     */
    private String accountNo;
    /**
     * 订单金额
     */
    private Integer money;
    /**
     * 商品数量
     */
    private Integer num;

    /**
     * 用户积分
     */
    public Integer score;
}
