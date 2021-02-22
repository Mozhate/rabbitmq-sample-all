package com.laher.spring.boot.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.laher.spring.boot.constants.RabbitConstant;

/**
 * direct 交换机
 * <p>
 *
 * @author laher
 * @version 1.0.0
 * @date 2021/2/5
 */
@Configuration
public class RabbitDirectConfig {
    /**
     * 使用默认队列和默认交换机
     *
     * 提前声明queue 否则报错
     *
     * @return 队列信息
     * @author laher
     * @version 1.0.0
     * @date 2021/2/5
     */
    @Bean
    public Queue defaultQueue() {
        return new Queue(RabbitConstant.DEFAULT_TEST_QUEUE);
    }

}
