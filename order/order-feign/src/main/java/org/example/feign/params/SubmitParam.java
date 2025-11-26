package org.example.feign.params;

import lombok.Data;

/**
 *
 * 订单参数
 *
 * @author LXZ 2025/11/24 17:21
 */
@Data
public class SubmitParam {

    /**
     * 账户号
     */
    private String accountNo;
    /**
     * 订单金额
     */
    private Integer money;
}
