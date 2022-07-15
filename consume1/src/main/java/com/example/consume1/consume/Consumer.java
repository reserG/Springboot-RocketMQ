package com.example.consume1.consume;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 设置消息监听
 * 监听组：监听topic：监听tag(默认监听topic下所有)
 * 监听消费模式:默认负载均衡：CLUSTERING（每一个消息只发给一个消费者）、广播模式：BROADCASTING（发送给所有消费者）
 *
 */
@Component
@RocketMQMessageListener(consumerGroup = "group_rocketmq", topic = "${rocketmq.consumer.topic}",
        selectorExpression = "${rocketmq.consumer.tags}", messageModel = MessageModel.BROADCASTING)
@Slf4j
public class Consumer implements RocketMQListener<String> {

    @Value(value = "${rocketmq.consumer.group}")
    private String consumerGroup;
    @Value(value = "${rocketmq.consumer.tags}")
    private String tag;
    @Override
    public void onMessage(String message) {
        System.out.println("time :"+ new Date().toString() + message);
    }
}