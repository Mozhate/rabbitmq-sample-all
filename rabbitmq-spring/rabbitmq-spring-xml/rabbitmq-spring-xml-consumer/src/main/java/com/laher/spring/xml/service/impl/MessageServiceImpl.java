package com.laher.spring.xml.service.impl;

import com.laher.spring.xml.service.MessageService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 消息服务
 * <p>
 *
 * @author laher
 * @version 1.0.0
 * @date 2021/2/5
 */
@Service(value = "messageService")
public class MessageServiceImpl implements MessageService {

    @Resource(name = "rabbitTemplateDirect")
    private RabbitTemplate rabbitTemplateDirect;

    @Resource(name = "rabbitTemplateTopic")
    private RabbitTemplate rabbitTemplateTopic;

    /**
     * 推送定点消息
     *
     * @param message 推送内容
     * @author laher
     * @date 2021/2/5
     */
    @Override
    public void pushMessage(String message) {
        rabbitTemplateDirect.convertAndSend("messageTest", message);
    }

    /**
     * 推送topic消息
     *
     * @param message 推送内容
     * @author laher
     * @date 2021/2/5
     */
    @Override
    public void pushTopicMessage(String message) {
        // topic类型交换机，路由规则匹配
        rabbitTemplateTopic.convertAndSend("messageQueue2.hello", message);
    }
}
