package com.laher.spring.boot.service.impl;

import com.laher.spring.boot.constants.RabbitConstant;
import com.laher.spring.boot.service.TestMessageService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 测试消费服务
 * <p>
 *
 * @author laher
 * @version 1.0.0
 * @date 2021/2/22
 */
@Service(value = "testMessageService")
public class TestMessageServiceImpl implements TestMessageService {

    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 默认消息推送
     *
     * @param message 推送信息
     * @author laher
     * @version 1.0.0
     * @date 2021/2/22
     */
    @Override
    public void defaultTestMessage(String message) {
        rabbitTemplate.convertAndSend(RabbitConstant.DEFAULT_TEST_QUEUE, message);
    }

    /**
     * direct交换机消息推送
     *
     * @param message 推送信息
     * @author laher
     * @version 1.0.0
     * @date 2021/2/22
     */
    @Override
    public void directTestMessage(String message) {
        rabbitTemplate.convertAndSend(RabbitConstant.DIRECT_TEST_EXCHANGE, RabbitConstant.DIRECT_TEST_QUEUE, message);
    }
}
