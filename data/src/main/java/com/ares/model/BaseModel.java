package com.ares.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体基类
 *
 * @author 0xZzzz
 * @date 2018/10/17
 */
@Data
public class BaseModel implements Serializable {

    public static final long serialVersionUID = 1L;

    private Date modified;

    private Date created;

    private Long id;

}
