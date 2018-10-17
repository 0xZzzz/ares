package com.ares.service.message.handler;

import com.ares.service.middleware.Message;

import java.util.List;

/**
 * 消息处理器
 *
 * @author 0xzzzz
 * @date 2018/10/16
 */
public interface MessageHandler {

    /**
     * 处理消息
     *
     * @param messageList 消息集合
     * @throws Exception 消息处理异常
     */
    void handle(List<Message> messageList) throws Exception;

}
