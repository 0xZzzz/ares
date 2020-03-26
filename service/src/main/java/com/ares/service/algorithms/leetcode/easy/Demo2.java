package com.ares.service.algorithms.leetcode.easy;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author fansheng
 * @date 2020/3/26
 */
public class Demo2 {

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int result = 13;
        algorithms1(arr, result);
        algorithms2(arr, result);
        algorithms3(arr, result);
    }

    /**
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
    public static void algorithms3(int[] arr, int result) {
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
