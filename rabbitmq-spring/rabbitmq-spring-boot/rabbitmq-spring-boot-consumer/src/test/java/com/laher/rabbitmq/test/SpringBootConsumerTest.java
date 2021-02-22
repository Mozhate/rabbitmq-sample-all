package com.laher.rabbitmq.test;

import com.laher.spring.boot.RabbitConsumerApplication;
import com.laher.spring.boot.service.TestMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 测试消息
 * <p>
 *
 * @author laher
 * @version 1.0.0
 * @date 2021/2/22
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RabbitConsumerApplication.class})
public class SpringBootConsumerTest {
    @Resource
    private TestMessageService testMessageService;

    @Test
    public void testDefault() {
        testMessageService.defaultTestMessage("推送默认消息");
        System.out.println("推送消息成功");
    }

}
