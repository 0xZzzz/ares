package com.ares.domain.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 领域实体
 */
@Getter
@AllArgsConstructor
public class Entity {

    /**
     * 实体唯一标识
     */
    private final String id;

    /**
     * 版本号
     */
    private Integer version;

}
