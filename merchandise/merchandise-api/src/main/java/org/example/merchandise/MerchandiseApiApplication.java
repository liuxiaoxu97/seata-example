package org.example.merchandise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *
 * ${DESC}
 *
 * @author LXZ 2025/11/24 14:57
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MerchandiseApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(MerchandiseApiApplication.class, args);
    }
}