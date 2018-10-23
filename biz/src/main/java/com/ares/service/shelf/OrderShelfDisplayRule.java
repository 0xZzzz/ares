package com.ares.service.shelf;

import com.ares.domain.ShelfDisplayContext;
import org.springframework.stereotype.Service;

/**
 * 货架陈列规则（按净含量排序）
 *
 * @author 0xzzzz
 * @date 2018/10/18
 */
@Service
public class OrderShelfDisplayRule extends AbstractShelfDisplayRule {

    @Override
    public void execute(ShelfDisplayContext ctx) {
        ctx.getDisplayItemList().forEach(
            itemList -> itemList.sort((o1, o2) -> o1.getNetWeight().equals(o2.getNetWeight()) ? 0
                : o1.getNetWeight() > o2.getNetWeight() ? 1 : -1));
    }

    @Override
    public int getSort() {
        return 2;
    }
}
