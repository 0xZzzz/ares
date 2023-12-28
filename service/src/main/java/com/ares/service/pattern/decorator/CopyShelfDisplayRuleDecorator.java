package com.ares.service.pattern.decorator;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 货架陈列规则（复制商品）
 *
 * @author 0xZzzz
 * @date 2018/10/18
 */
public class CopyShelfDisplayRuleDecorator extends AbstractShelfDisplayRuleDecorator {

    private static final int COPY_ITEM_NUM = 3;

    public CopyShelfDisplayRuleDecorator(ShelfDisplayRule rule) {
        super(rule);
    }

    @Override
    public List<List<Item>> execute(List<Item> selectedItems) {
        List<List<Item>> displayItems = super.execute(selectedItems);
        List<List<Item>> copiedDisplayItems = Lists.newArrayList();
        displayItems.forEach(itemList -> {
            List<Item> rowItems = Lists.newArrayList();
            itemList.forEach(item -> {
                for (int i = 0; i < COPY_ITEM_NUM; i++) {
                    rowItems.add(item);
                }
            });
            copiedDisplayItems.add(rowItems);
        });
        return copiedDisplayItems;
    }

}
