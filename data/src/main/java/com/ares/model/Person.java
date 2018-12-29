package com.ares.model;

import lombok.Data;
import lombok.ToString;

/**
 * @author 0xZzzz
 */
@Data
@ToString(callSuper = true)
public class Person extends BaseModel {

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private Byte gender;

}
