package com.ares.service.pattern.state;

/**
 * 作业状态
 *
 * @author  0xZzzz
 * @date 2020/11/4
 */
public enum TaskStatus {

    /**
     * 已创建
     */
    CREATED,

    /**
     * 已领取
     */
    CLAIMED,

    /**
     * 已开始
     */
    STARTED,

    /**
     * 已完成
     */
    FINISHED,

    /**
     * 已关闭
     */
    CLOSED

}
