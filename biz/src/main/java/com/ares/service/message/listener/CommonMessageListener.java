package com.ares.service.message.listener;

import com.ares.common.exception.BusinessException;
import com.ares.common.utils.Alarm;
import com.ares.common.utils.CollectionUtils;
import com.ares.service.message.handler.MessageHandler;
import com.ares.service.middleware.Message;
import com.ares.service.middleware.MessageListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 消息监听器抽象基类
 *
 * @author 0xzzzz
 * @date 2018/10/16
 */
public class CommonMessageListener implements MessageListener {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    private boolean isLogMessage;

    private MessageHandler messageHandler;

    @Override
    public void onMessage(List<Message> messageList) throws Exception {
        if (CollectionUtils.isEmpty(messageList)) {
            return;
        }
        Alarm.start();
        try {
            if (isLogMessage) {
                logger.info("message: {}", messageList);
            }
            messageHandler.handle(messageList);
        } catch (BusinessException e) {
            logger.error("biz error!", e);
        } catch (Exception e) {
            logger.error("error!", e);
            Alarm.error();
            throw e;
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
