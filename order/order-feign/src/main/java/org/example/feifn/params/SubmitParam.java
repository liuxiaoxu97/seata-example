package org.example.feifn.params;

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
     * 订单号
     */
    private String orderNo;
    /**
     * 订单金额
     */
    private Integer account;
}
