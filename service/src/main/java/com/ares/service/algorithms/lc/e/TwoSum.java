package com.ares.service.algorithms.lc.e;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 1
 * https://leetcode-cn.com/problems/two-sum/
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例：
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 *
 * @author  0xZzzz
 * @date 2020/3/26
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int result = 13;
        algorithms1(arr, result);
        algorithms2(arr, result);
        algorithms3(arr, result);
    }

    /**
     * 双层循环遍历
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     */
    private static void algorithms1(int[] arr, int result) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == result) {
                    System.out.println(i + "," + j);
                    return;
                }
            }
        }
    }

    /**
     * 采用减法运算，将数组的值作为key，下标作为value，存储到一个map中，
     * 遍历原数组用目标值减去当前值，如果差在map中能找到并且下标不等于当前值，则当前值和差值为解
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    private static void algorithms2(int[] arr, int result) {
        Map<Integer, Integer> map = Maps.newHashMap();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            int complement = result - arr[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                System.out.println(i + "," + map.get(complement));
                return;
            }
        }
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    private static void algorithms3(int[] arr, int result) {
        Map<Integer, Integer> map = Maps.newHashMap();
        for (int i = 0; i < arr.length; i++) {
            int complement = result - arr[i];
            if (map.containsKey(complement)) {
                System.out.println(i + "," + map.get(complement));
                return;
            }
            map.put(arr[i], i);
        }
    }

}
