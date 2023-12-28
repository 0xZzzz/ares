package com.ares.service.pattern.decorator;

import lombok.Data;

import java.util.List;

/**
 * 获取陈列上下文
 *
 * @author 0xZzzz
 */
@Data
public class ShelfDisplayContext {

    /**
     * 选品列表
     */
    private List<Item> selectItemList;

    /**
     * 陈列列表
     */
    private List<List<Item>> displayItemList;

}
