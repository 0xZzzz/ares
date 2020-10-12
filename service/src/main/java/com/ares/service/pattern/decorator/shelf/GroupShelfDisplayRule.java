package com.ares.service.pattern.decorator.shelf;

import com.ares.model.Item;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 货架陈列规则（按品牌分组）
 *
 * @author 0xzzzz
 * @date 2018/10/18
 */
public class GroupShelfDisplayRule implements ShelfDisplayRule {

    @Override
    public List<List<Item>> execute(List<Item> selectedItems) {
        Map<Long, List<Item>> brandGroup = selectedItems.stream().collect(Collectors.groupingBy(Item::getBrandId));
        List<List<Item>> displayItems = Lists.newArrayList();
        brandGroup.forEach((brandId, itemGroupList) -> displayItems.add(itemGroupList));
        return displayItems;
    }

}
