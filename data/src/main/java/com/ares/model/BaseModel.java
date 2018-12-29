package com.ares.model;

import lombok.Data;

import java.util.Date;

/**
 * 实体基类
 *
 * @author 0xZzzz
 * @date 2018/10/17
 */
@Data
public class BaseModel {

    private Date modified;

    private Date created;

    private Long id;

}
