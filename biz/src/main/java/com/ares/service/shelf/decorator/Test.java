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
            new Item("康师傅1L", 3L, 1L),
            new Item("娃哈哈2L", 2L, 2L),
            new Item("康师傅2L", 3L, 2L),
            new Item("今麦郎1L", 1L, 1L),
            new Item("玩哈哈1L", 2L, 1L),
            new Item("今麦郎2L", 1L, 2L)
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
