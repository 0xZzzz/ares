package com.ares.service.message.listener;

import com.ares.common.exception.BusinessException;
import com.ares.common.exception.SystemException;
import com.ares.common.utils.Alarm;
import com.ares.service.message.handler.MessageHandler;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 消息监听器抽象基类
 *
 * @author 0xzzzz
 * @date 2018/10/16
 */
public class CommonMessageListener implements MessageListenerOrderly {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    private boolean isLogMessage;

    private MessageHandler messageHandler;

    @Override
    public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext) {
        Alarm.start();
        try {
            if (isLogMessage) {
                logger.info("message: {}", list);
            }
            messageHandler.handle(list);
            return ConsumeOrderlyStatus.SUCCESS;
        } catch (BusinessException e) {
            logger.error("biz error!", e);
            return ConsumeOrderlyStatus.SUCCESS;
        } catch (Exception e) {
            logger.error("error!", e);
            Alarm.error();
            throw new SystemException(e);
        } finally {
            Alarm.end();
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
