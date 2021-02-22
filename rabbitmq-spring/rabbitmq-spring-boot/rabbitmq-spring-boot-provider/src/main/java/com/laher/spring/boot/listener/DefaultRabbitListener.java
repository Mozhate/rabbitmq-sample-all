package com.laher.spring.boot.listener;

import com.laher.spring.boot.constants.RabbitConstant;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * 默认消息接收监听
 * <p>
 *
 * @author laher
 * @version 1.0.0
 * @date 2021/2/22
 */
@Component
public class DefaultRabbitListener {

    /**
     * 最简易基于默认Direct交换机的监听器
     *
     * @param message 推送消息
     * @param channel 渠道
     * @param tag     交付标签id
     */
    @RabbitHandler
    @RabbitListener(queues = RabbitConstant.DEFAULT_TEST_QUEUE)
    public void defaultMessage(Message message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        System.out.println("defaultTestQueue开始消费：" + new String(message.getBody(), StandardCharsets.UTF_8));
        // defaultTestQueue开始消费：推送默认消息
    }
}
