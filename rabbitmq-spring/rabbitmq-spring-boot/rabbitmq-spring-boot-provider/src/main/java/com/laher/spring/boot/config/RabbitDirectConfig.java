package com.laher.spring.boot.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
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
     * <p>
     * 提前声明queue 否则报错
     *
     * @return 队列信息
     * @author laher
     * @version 1.0.0
     * @date 2021/2/5
     */
    @Bean
    public Queue defaultQueue() {
        // 队列名称，是否持久化
        return new Queue(RabbitConstant.DEFAULT_TEST_QUEUE, true);
    }

//    /**
//     * 一：声明direct交换机
//     *
//     * @return 交换机信息
//     * @author laher
//     * @version 1.0.0
//     * @date 2021/2/5
//     */
//    @Bean
//    public DirectExchange directExchange() {
//        // 交换机名称，是否持久化，是否自动删除（没有生产者或消费者会自动删除）
//        return new DirectExchange(RabbitConstant.DIRECT_TEST_EXCHANGE, true, false);
//    }
//
//    /**
//     * 二：声明queue
//     *
//     * @return 队列信息
//     * @author laher
//     * @version 1.0.0
//     * @date 2021/2/5
//     */
//    @Bean
//    public Queue directQueue() {
//        // 队列名称，是否持久化
//        return new Queue(RabbitConstant.DIRECT_TEST_QUEUE, true);
//    }
//
//    /**
//     * 三：绑定queue和exchange
//     *
//     * @return 绑定信息
//     * @author laher
//     * @version 1.0.0
//     * @date 2021/2/5
//     */
//    @Bean
//    public Binding directExchangeBindingQueue(@Qualifier("directExchange") DirectExchange directExchange,
//                                              @Qualifier("directQueue") Queue directQueue) {
//        // 绑定queue和directExchange，并且queue的名称为routingKey
//        return BindingBuilder.bind(directQueue).to(directExchange).withQueueName();
//    }
}
