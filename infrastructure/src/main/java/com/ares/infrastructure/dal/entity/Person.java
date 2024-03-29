package com.ares.infrastructure.dal.entity;

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

    /**
     * 公司id
     */
    private Long companyId;

    /**
     * 公司信息
     */
    private Company company;

}
