package com.ares.service.shelf;

import com.ares.domain.Item;
import com.ares.domain.ShelfDisplayContext;
import com.google.common.collect.Lists;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 货架陈列规则（按品牌分组）
 *
 * @author 0xzzzz
 * @date 2018/10/18
 */
@Service
public class GroupShelfDisplayRule extends AbstractShelfDisplayRule {

    @Override
    public void execute(ShelfDisplayContext ctx) {
        Map<Long, List<Item>> brandGroup =
            ctx.getSelectItemList().stream().collect(Collectors.groupingBy(Item::getBrandId));
        List<List<Item>> displayItemList = Lists.newArrayList();
        brandGroup.forEach((brandId, itemGroupList) -> displayItemList.add(itemGroupList));
        ctx.setDisplayItemList(displayItemList);
    }

    @Override
    public int getSort() {
        return 1;
    }
}
