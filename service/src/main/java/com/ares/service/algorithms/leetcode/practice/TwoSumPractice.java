package com.ares.service.algorithms.leetcode.practice;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * {@link com.ares.service.algorithms.leetcode.easy.TwoSum} practice
 *
 * @author fansheng
 * @date 2021/7/21
 */
public class TwoSumPractice {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 9, 13};
        twoSum(nums, 16);
    }

    /**
     * 时间 O(N)
     * 空间 O(N)
     */
    private static void twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = Maps.newHashMap();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int m = target - n;
            if (map.get(m) != null && map.get(m) != i) {
                System.out.println(target + " = " + n + " + " + m);
                break;
            }
            map.put(n, i);
        }
    }

}
