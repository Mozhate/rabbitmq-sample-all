package com.laher.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 接收服务应用
 * <p>
 *
 * @author laher
 * @version 1.0.0
 * @date 2021/2/22
 */
@SpringBootApplication(scanBasePackages = "com.laher")
public class RabbitProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitProviderApplication.class);
    }
}
