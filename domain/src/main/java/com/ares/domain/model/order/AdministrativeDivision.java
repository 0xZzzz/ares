package com.ares.domain.model.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 行政区划
 */
@Getter
@ToString
@AllArgsConstructor
public class AdministrativeDivision {

    /**
     * 行政区编码
     */
    private String code;

    /**
     * 行政区名称
     */
    private String name;

}
