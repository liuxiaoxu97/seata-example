package org.example.merchandise.entity;

import lombok.Data;

/**
 *
 *
 * @author LXZ 2025/11/24 18:14
 */
@Data
@Entity
@Table(name = "merchandise")
public class Merchandise {

    /**
     * 主键
     */
    private Long id;
    /**
     * 数量
     */
    private Integer number;
    /**
     * 预数量
     */
    private Integer preNumber;
}
