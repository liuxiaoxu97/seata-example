package org.example.merchandise.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

/**
 *
 * mapper 接口扫码
 *
 * @author LXZ 2025/11/25 12:09
 */
@Configuration
@MapperScan("org.example.merchandise.mapper")
public class MybatisPlusConfig {

    /**
     * 自动填充配置
     */
    @Bean
    public MetaObjectHandler metaObjectHandler() {
        return new MetaObjectHandler() {

            @Override
            public void insertFill(MetaObject metaObject) {
                // 插入时自动填充
                this.strictInsertFill(metaObject, "createAt", LocalDateTime.class, LocalDateTime.now());
                this.strictInsertFill(metaObject, "updateAt", LocalDateTime.class, LocalDateTime.now());
            }

            @Override
            public void updateFill(MetaObject metaObject) {
                // 更新时自动填充
                this.strictUpdateFill(metaObject, "updateAt", LocalDateTime.class, LocalDateTime.now());
            }
        };
    }
}
