package com.ares.service.pattern.composite;

import com.google.common.collect.Lists;
import lombok.ToString;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * 容器 HU
 *
 * @author  0xZzzz
 * @date 2020/11/12
 */
@ToString(callSuper = true)
public class ContainerHu extends BaseHu {

    /**
     * 容器内 hu 列表
     */
    private final List<BaseHu> huList;

    public ContainerHu(Long id, Long warehouseId, Long weight) {
        super(id, warehouseId, weight);
        huList = Lists.newArrayList();
    }

    @Override
    public long calculateTotalWeight() {
        long weight = this.weight;
        if (CollectionUtils.isNotEmpty(huList)) {
            for (BaseHu hu : huList) {
                weight += hu.calculateTotalWeight();
            }
        }
        return weight;
    }

    @Override
    public void add(BaseHu hu) {
        huList.add(hu);
    }

    @Override
    public BaseHu takeOut(Long huId) {
        BaseHu hu = CollectionUtils.emptyIfNull(huList).stream().filter(h -> h.id.equals(huId)).findAny().orElse(null);
        if (hu != null) {
            huList.remove(hu);
        }
        return hu;
    }
}
