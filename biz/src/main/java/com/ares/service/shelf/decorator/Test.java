package com.ares.service.shelf.decorator;

import com.ares.domain.Item;
import com.ares.domain.ShelfDisplayContext;
import com.google.common.collect.Lists;

/**
 * 测试类
 *
 * @author 0xZzzz
 */
public class Test {

    public static void main(String[] args) {

        ShelfDisplayContext ctx = new ShelfDisplayContext();
        ctx.setSelectItemList(Lists.newArrayList(
            new Item("3.1", 3L, 1L),
            new Item("2.2", 2L, 2L),
            new Item("3.2", 3L, 2L),
            new Item("1.1", 1L, 1L),
            new Item("2.1", 2L, 1L),
            new Item("1.2", 1L, 2L)
        ));
        System.out.println();
        ShelfDisplayRule rule = new GroupShelfDisplayRule();
        rule = new OrderShelfDisplayRuleDecorator(rule);
        rule = new CopyShelfDisplayRuleDecorator(rule);
        rule.execute(ctx);
        ctx.getDisplayItemList().forEach(itemList -> {
            StringBuilder printString = new StringBuilder();
            itemList.forEach(item -> printString.append(item.getName()).append("  "));
            System.err.println(printString.toString());
        });
    }

}
