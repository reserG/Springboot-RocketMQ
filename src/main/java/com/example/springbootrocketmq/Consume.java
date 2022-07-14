package com.example.springbootrocketmq;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "first-topic", consumerGroup = "my-consumer-group")

public class Consume implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        System.out.println(message);

    }
}
