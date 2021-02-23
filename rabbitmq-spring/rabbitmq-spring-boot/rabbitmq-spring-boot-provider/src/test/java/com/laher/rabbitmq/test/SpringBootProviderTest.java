package com.laher.rabbitmq.test;

import com.laher.spring.boot.RabbitProviderApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

/**
 * 测试消息
 * <p>
 *
 * @author laher
 * @version 1.0.0
 * @date 2021/2/22
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RabbitProviderApplication.class})
public class SpringBootProviderTest {
    @Test
    public void runTest() throws InterruptedException {
        // 启动项目会将各rabbitMq监听器启动
        System.out.println("启动项目");
        new CountDownLatch(1).await();
    }

}
