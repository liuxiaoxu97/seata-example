package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *
 * ${DESC}
 *
 * @author LXZ 2025/11/23 19:11
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "org.example.feign")
public class PlatformApiApplication {
    public static void main(String[] args) {
     SpringApplication.run(PlatformApiApplication.class, args);
    }
}