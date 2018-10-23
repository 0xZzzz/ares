package com.ares.service.shelf.decorator;

import com.ares.domain.ShelfDisplayContext;

/**
 * 货架陈列规则
 *
 * @author 0xzzzz
 * @date 2018/10/18
 */
public abstract class AbstractShelfDisplayRuleDecorator implements ShelfDisplayRule {

    private ShelfDisplayRule rule;

    public AbstractShelfDisplayRuleDecorator(ShelfDisplayRule rule) {
        this.rule = rule;
    }

    @Override
    public void execute(ShelfDisplayContext ctx) {
        rule.execute(ctx);
    }
}
