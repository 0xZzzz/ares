package com.ares.domain.model.order;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author fansheng
 * @date 2023/12/28
 */
@Getter
@AllArgsConstructor
public class Buyer {

    /**
     * 买家id
     */
    private final String id;

    /**
     * 买家姓名
     */
    private final String name;

}
