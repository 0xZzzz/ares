package com.ares.service.middleware;

import java.util.List;

/**
 * 消息监听器
 *
 * @author 0xZzzz
 * @date 2018/10/16
 */
public interface MessageListener {

    /**
     * 消息通知
     *
     * @param messageList 消息列表
     */
    void onMessage(List<Message> messageList) throws Exception;

}
