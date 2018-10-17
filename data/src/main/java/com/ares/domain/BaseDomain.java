package com.ares.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 实体基类
 *
 * @author 0xzzzz
 * @date 2018/10/17
 */
public class BaseDomain {

    @Getter
    @Setter
    private Date modified;

    @Getter
    @Setter
    private Date created;

    @Getter
    @Setter
    private Long id;

}
