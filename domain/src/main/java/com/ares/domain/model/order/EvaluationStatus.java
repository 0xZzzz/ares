package com.ares.domain.model.order;

import lombok.AllArgsConstructor;

/**
 * 评价状态
 *
 * @author fansheng
 * @date 2023/12/28
 */
@AllArgsConstructor
public enum EvaluationStatus {

    /**
     * 无需处理
     */
    NOT_REQUIRED(0),

    /**
     * 已评价
     */
    DONE(1),

    /**
     * 未处理
     */
    NOT_PROCESSED(2);

    private final int code;

    private int code() {
        return code;
    }

}
