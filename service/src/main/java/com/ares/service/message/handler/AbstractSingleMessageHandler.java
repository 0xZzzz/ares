package com.ares.service.message.handler;

import com.ares.domain.exception.SystemException;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 单条消息处理器
 *
 * @author 0xZzzz
 * @date 2018/10/16
 */
public abstract class AbstractSingleMessageHandler<D> implements MessageHandler {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void handle(List<MessageExt> messageList) throws Exception {
        if (messageList.size() != 1) {
            throw new SystemException("消息数量不为1");
        }
        MessageExt message = messageList.get(0);
        // 解析消息
        D domain = parse(message);
        logger.info("handler messageDomain: {}", domain);
        // 校验解析后的消息
        if (!validate(domain)) {
            logger.info("validate not pass! domain: {}", domain);
            return;
        }
        handle(message, domain);
    }

    /**
     * 解析消息，用于将消息解析为实体
     *
     * @param message 消息对象
     * @return M
     */
    protected abstract D parse(MessageExt message);

    /**
     * 校验消息实体
     *
     * @param m 消息实体
     * @return true：通过，false：不通过
     */
    protected boolean validate(D m) {
        return m != null;
    }

    /**
     * 处理消息
     *
     * @param message 消息对象
     * @param domain  消息实体
     * @throws Exception 处理异常
     */
    protected abstract void handle(MessageExt message, D domain) throws Exception;

}
