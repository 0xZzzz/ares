package com.ares.service.message.listener;

import com.ares.common.exception.BusinessException;
import com.ares.service.message.handler.MessageHandler;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 消息监听器抽象基类
 *
 * @author 0xZzzz
 * @date 2018/10/16
 */
public class CommonMessageListener implements MessageListenerConcurrently {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    private boolean isLogMessage = true;

    private MessageHandler messageHandler;

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list,
                                                    ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        try {
            if (isLogMessage) {
                logger.info("message: {}", list);
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        } catch (BusinessException e) {
            logger.error("biz error!", e);
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        } catch (Exception e) {
            logger.error("error!", e);
            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
        }
    }

    /**
     * 设置是否打印消息
     *
     * @param logMessage true：打印，false：不打印
     */
    public void setLogMessage(boolean logMessage) {
        isLogMessage = logMessage;
    }

    public void setMessageHandler(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }

}
