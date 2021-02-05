package com.laher.rabbitmq.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * 测试监听消息
 * <p>
 *
 * @author laher
 * @version 1.0.0
 * @date 2021/2/5
 */
public class SpringXmlProviderTest {

    private ApplicationContext context = null;

    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext("application.xml");
    }

    @Test
    public void testPushMessage() throws InterruptedException {
        System.out.println("监听项目启动成功");

        new CountDownLatch(1).await();
    }


}
