package com.ares.infrastructure.dal.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author 0xZzzz
 */
@Data
@ToString(callSuper = true)
public class Company extends BaseModel {

    /**
     * 姓名
     */
    private String name;

}
