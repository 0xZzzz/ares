package com.ares.service.middleware;

/**
 * 消息
 *
 * @author 0xzzzz
 * @date 2018/10/16
 */
public class Message {

    /**
     * 消息id
     */
    private String businessId;

    /**
     * 消息内容
     */
    private String text;

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" +
            "businessId='" + businessId + '\'' +
            ", text='" + text + '\'' +
            '}';
    }
}
