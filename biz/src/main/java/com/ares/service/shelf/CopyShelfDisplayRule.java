package com.ares.service.shelf;

import com.ares.domain.Item;
import com.ares.domain.ShelfDisplayContext;
import com.google.common.collect.Lists;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 货架陈列规则（复制商品）
 *
 * @author 0xzzzz
 * @date 2018/10/18
 */
@Service
public class CopyShelfDisplayRule extends AbstractShelfDisplayRule {

    private static final int COPY_ITEM_NUM = 3;

    @Override
    public void execute(ShelfDisplayContext ctx) {
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

    @Override
    public int getSort() {
        return 3;
    }
}
