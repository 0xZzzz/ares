package com.ares.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * rocket mq 工具类
 *
 * @author 0xzzzz
 * @date 2018/10/18
 */
@Service
@Slf4j
public class RocketMQUtils {

    @Autowired
    private DefaultMQProducer producer;

    /**
     * 发送消息
     *
     * @param topic topic
     * @param text  内容
     */
    public void send(String topic, String text) {
        try {
            Message message = new Message(topic, text.getBytes());
            producer.send(message);
        } catch (Exception e) {
            log.error("send error! topic: {}, text: {}", topic, text, e);
        }
    }

}
