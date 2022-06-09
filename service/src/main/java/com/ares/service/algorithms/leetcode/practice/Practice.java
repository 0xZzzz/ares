package com.ares.service.algorithms.leetcode.practice;

import java.util.*;

/**
 * @author fansheng
 * @date 2022/5/30
 */
public class Practice {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{1,-1,-1,0}));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int l = nums.length;
        for (int i = 0; i < l - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int first = nums[i];
            int target = -first;
            int right = l - 1;
            for (int j = i + 1; j < l; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int second = nums[j];
                while (right > j && second + nums[right] > target) {
                    right--;
                }
                if (j == right) {
                    break;
                }
                if (second + nums[right] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(first);
                    list.add(second);
                    list.add(nums[right]);
                    result.add(list);
                }
            }
        }
        return result;
    }

}
