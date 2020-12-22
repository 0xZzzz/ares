package com.ares.service.algorithms.greedy;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 贪婪算法
 * <p>
 * 寻找局部最优解，从而获得全局最优解
 *
 * @author fansheng
 * @date 2020/12/21
 */
public class GreedyDemo1 {

    public static void main(String[] args) {

        Map<String, int[]> classes = Maps.newHashMap();
        classes.put("A", new int[]{900, 1000});
        classes.put("B", new int[]{930, 1030});
        classes.put("C", new int[]{1000, 1100});
        classes.put("D", new int[]{1030, 1130});
        classes.put("E", new int[]{1100, 1200});

        algorithms(classes);

    }

    /**
     * 时间复杂度 O(n^2)
     */
    private static void algorithms(Map<String, int[]> classes) {
        List<String> selected = Lists.newArrayList();
        int minimumStartTime = Integer.MIN_VALUE;
        while (!classes.isEmpty()) {
            int minimumEndTime = Integer.MAX_VALUE;
            String currClass = null;
            Iterator<Map.Entry<String, int[]>> it = classes.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, int[]> entry = it.next();
                int[] period = entry.getValue();
                if (period[0] < minimumStartTime) {
                    it.remove();
                } else if (period[1] < minimumEndTime) {
                    minimumEndTime = period[1];
                    currClass = entry.getKey();
                }
            }
            minimumStartTime = minimumEndTime;
            selected.add(currClass);
            classes.remove(currClass);
        }
        System.out.println(selected);
    }

}
