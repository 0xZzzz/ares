package com.ares.infrastructure.pattern.decorator;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 装饰者测试类
 *
 * @author 0xZzzz
 */
public class DecoratorTest {

    private static final String ORDER_CMD = "-o";

    private static final String COPY_CMD = "-c";

    public static void main(String[] args) {
        List<String> commands = Lists.newArrayList(args);
        // 选品列表
        List<Item> selectedItems = Lists.newArrayList(
            new Item("康师傅1L", 3L, 1L),
            new Item("娃哈哈2L", 2L, 2L),
            new Item("康师傅2L", 3L, 2L),
            new Item("今麦郎1L", 1L, 1L),
            new Item("玩哈哈1L", 2L, 1L),
            new Item("今麦郎2L", 1L, 2L));
        // 根据命令确定陈列规则
        ShelfDisplayRule rule = new GroupShelfDisplayRule();
        if (commands.contains(ORDER_CMD)) {
            rule = new OrderShelfDisplayRuleDecorator(rule);
        }
        if (commands.contains(COPY_CMD)) {
            rule = new CopyShelfDisplayRuleDecorator(rule);
        }
        // 执行陈列规则
        List<List<Item>> displayItems = rule.execute(selectedItems);
        // 打印陈列结果
        displayItems.forEach(itemList -> {
            StringBuilder printString = new StringBuilder();
            itemList.forEach(item -> printString.append(item.getName()).append("  "));
            System.err.println(printString);
        });
    }

}
