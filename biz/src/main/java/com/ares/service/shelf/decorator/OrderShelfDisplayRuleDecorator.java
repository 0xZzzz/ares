package com.ares.service.shelf.decorator;

import com.ares.domain.ShelfDisplayContext;

/**
 * 货架陈列规则（按净含量排序）
 *
 * @author 0xzzzz
 * @date 2018/10/18
 */
public class OrderShelfDisplayRuleDecorator extends AbstractShelfDisplayRuleDecorator {

    public OrderShelfDisplayRuleDecorator(ShelfDisplayRule rule) {
        super(rule);
    }

    @Override
    public void execute(ShelfDisplayContext ctx) {
        super.execute(ctx);
        ctx.getDisplayItemList().forEach(
            itemList -> itemList.sort((o1, o2) -> o1.getNetWeight().equals(o2.getNetWeight()) ? 0
                : o1.getNetWeight() > o2.getNetWeight() ? 1 : -1));
    }

}
