package com.laher.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 推送服务应用
 * <p>
 *
 * @author laher
 * @version 1.0.0
 * @date 2021/2/5
 */
@SpringBootApplication(scanBasePackages = "com.laher")
public class RabbitConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitConsumerApplication.class);
    }
}
