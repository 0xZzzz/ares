package com.ares.service.pattern.decorator;

import java.util.List;

/**
 * 货架陈列规则（按净含量排序）
 *
 * @author 0xZzzz
 * @date 2018/10/18
 */
public class OrderShelfDisplayRuleDecorator extends AbstractShelfDisplayRuleDecorator {

    public OrderShelfDisplayRuleDecorator(ShelfDisplayRule rule) {
        super(rule);
    }

    @Override
    public List<List<Item>> execute(List<Item> selectedItems) {
        List<List<Item>> displayItems = super.execute(selectedItems);
        displayItems.forEach(
            itemList -> itemList.sort((o1, o2) -> o1.getNetWeight().equals(o2.getNetWeight()) ? 0
                : o1.getNetWeight() > o2.getNetWeight() ? 1 : -1));
        return displayItems;
    }
}
