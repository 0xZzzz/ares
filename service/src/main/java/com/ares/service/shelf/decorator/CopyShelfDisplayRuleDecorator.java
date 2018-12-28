package com.ares.service.shelf.decorator;

import com.ares.domain.Item;
import com.ares.domain.ShelfDisplayContext;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * 货架陈列规则（复制商品）
 *
 * @author 0xzzzz
 * @date 2018/10/18
 */
public class CopyShelfDisplayRuleDecorator extends AbstractShelfDisplayRuleDecorator {

    private static final int COPY_ITEM_NUM = 3;

    public CopyShelfDisplayRuleDecorator(ShelfDisplayRule rule) {
        super(rule);
    }

    @Override
    public void execute(ShelfDisplayContext ctx) {
        super.execute(ctx);
        List<List<Item>> displayItemList = Lists.newArrayList();
        ctx.getDisplayItemList().forEach(itemList -> {
            List<Item> rowItemList = Lists.newArrayList();
            itemList.forEach(item -> {
                for (int i = 0; i < COPY_ITEM_NUM; i++) {
                    rowItemList.add(item);
                }
            });
            displayItemList.add(rowItemList);
        });
        ctx.setDisplayItemList(displayItemList);
    }

}
