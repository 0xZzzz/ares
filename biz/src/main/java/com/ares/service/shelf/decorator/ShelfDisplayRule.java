package com.ares.service.shelf.decorator;

import com.ares.domain.ShelfDisplayContext;

/**
 * 货架陈列规则
 *
 * @author 0xzzzz
 * @date 2018/10/18
 */
public interface ShelfDisplayRule {

    /**
     * 执行规则
     *
     * @param ctx 货架陈列上下文
     */
    void execute(ShelfDisplayContext ctx);

}
