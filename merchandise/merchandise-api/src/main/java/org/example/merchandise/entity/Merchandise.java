package org.example.merchandise.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 *
 *
 * @author LXZ 2025/11/24 18:14
 */
@Data
@TableName("merchandise")
public class Merchandise {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 数量
     */
    private Integer number;
    /**
     * 预数量
     */
    private Integer preNumber;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date createAt;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateAt;
}
