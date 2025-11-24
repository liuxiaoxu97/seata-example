package org.example.feign.params;

import lombok.Data;

/**
 *
 * 修改用户积分参数
 *
 * @author LXZ 2025/11/24 15:31
 */
@Data
public class UpdateUserDataParam {

    /**
     * 用户ID
     */
    public  Long userId;
    /**
     * 用户积分
     */
    public Integer score;
}
