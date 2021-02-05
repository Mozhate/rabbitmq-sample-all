package com.laher.rabbitmq.test;

import com.laher.spring.xml.service.MessageService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * 测试推送消息
 * <p>
 *
 * @author laher
 * @version 1.0.0
 * @date 2021/2/5
 */
public class SpringXmlConsumerTest {

    private ApplicationContext context = null;

    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext("application.xml");
    }

    @Test
    public void testPushMessage() throws InterruptedException {
        MessageService messageService = (MessageService) context.getBean("messageService");
        String message = "推送消息ABCD！";
        messageService.pushMessage(message);
        System.out.println("推送成功");

        new CountDownLatch(1).await();
    }


}
