package com.ares.infrastructure.algo.greedy;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.compress.utils.Lists;

import java.util.*;

/**
 * NP完全问题，贪婪算法可以近似解决NP完全问题，但可能不是最优解
 *
 * @author fansheng
 * @date 2020/12/22
 */
public class GreedyDemo2 {

    public static void main(String[] args) {
        // 初始化广播台信息
        Map<String, Set<String>> broadcasts = Maps.newHashMap();
        broadcasts.put("K1", Sets.newHashSet("ID", "NV", "UT"));
        broadcasts.put("K2", Sets.newHashSet("WA", "ID", "MT"));
        broadcasts.put("K3", Sets.newHashSet("OR", "NV", "CA"));
        broadcasts.put("K4", Sets.newHashSet("NV", "UT"));
        broadcasts.put("K5", Sets.newHashSet("CA", "AZ"));

        // 需要覆盖的全部地区
        Set<String> allAreas = Sets.newHashSet("ID", "NV", "UT", "WA", "MT", "OR", "CA", "AZ");
        // 所选择的广播台列表
        List<String> selected = Lists.newArrayList();

        while (!allAreas.isEmpty()) {
            Collection<String> maxCovered = Collections.emptySet();
            String key = null;
            for (Map.Entry<String, Set<String>> entry : broadcasts.entrySet()) {
                Set<String> set = entry.getValue();
                Collection<String> intersection = CollectionUtils.intersection(allAreas, set);
                if (intersection.size() > maxCovered.size()) {
                    maxCovered = intersection;
                    key = entry.getKey();
                }
            }
            allAreas.removeAll(maxCovered);
            selected.add(key);
        }
        System.out.println(selected);
    }

}
