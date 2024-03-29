package com.ares.infrastructure.pattern.decorator;

import java.util.List;

/**
 * 货架陈列规则装饰者抽象类
 *
 * @author 0xzzzz
 * @date 2018/10/18
 */
public abstract class AbstractShelfDisplayRuleDecorator implements ShelfDisplayRule {

    private final ShelfDisplayRule rule;

    public AbstractShelfDisplayRuleDecorator(ShelfDisplayRule rule) {
        this.rule = rule;
    }

    @Override
    public List<List<Item>> execute(List<Item> selectedItems) {
        return rule.execute(selectedItems);
    }
}
