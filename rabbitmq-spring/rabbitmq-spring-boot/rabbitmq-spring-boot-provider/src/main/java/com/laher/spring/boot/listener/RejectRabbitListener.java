package com.laher.spring.boot.listener;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import com.laher.spring.boot.constants.RabbitConstant;
import com.rabbitmq.client.Channel;

/**
 * 异常消息接收监听
 * <p>
 *
 * @author laher
 * @version 1.0.0
 * @date 2021/2/22
 */
@Component
public class RejectRabbitListener {

    private static AtomicInteger COUNT = new AtomicInteger(0);

    /**
     * Direct交换机的监听器
     * <p>
     * 通过注解方式绑定queue和exchange，且会自动注入到rabbitMQ
     *
     * @param message 推送消息
     * @param channel 渠道
     * @param tag     交付标签id
     */
    @RabbitHandler
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = RabbitConstant.REJECT_TEST_QUEUE),
            exchange = @Exchange(value = RabbitConstant.REJECT_TEST_EXCHANGE, type = ExchangeTypes.DIRECT)))
    public void directMessage(Message message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        System.out.println("rejectTestQueue开始消费：" + new String(message.getBody(), StandardCharsets.UTF_8));
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("消费异常");
            if (COUNT.get() < 2) {
                channel.basicNack(tag, false, true);
                System.out.println("异常后请求重试：" + COUNT.incrementAndGet());
            } else {
                // 当三次都失败后则取消该消息
                channel.basicReject(tag, false);
                System.out.println("消息拒绝");
                // 往后可以做死信消息存储库，进行定时重新推送MQ
            }
        }
        // rejectTestQueue开始消费：推送direct交换机消息
        // 消费异常
        // 异常后请求重试：1
        // rejectTestQueue开始消费：推送direct交换机消息
        // 消费异常
        // 异常后请求重试：2
        // rejectTestQueue开始消费：推送direct交换机消息
        // 消费异常
        // 消息拒绝
    }
}
