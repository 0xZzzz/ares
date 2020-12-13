package com.ares.service.algorithms.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/contains-duplicate/
 * <p>
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * <p>
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 * <p>
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * @author fansheng
 * @date 2020/12/13
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        algorithms1(nums);
    }

    /**
     * 时间复杂度：O(n)，其中 n 为数组的长度。
     * 空间复杂度：O(n)，其中 n 为数组的长度。
     */
    private static void algorithms1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        Set<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(set::add);
        System.out.println(set.size() != nums.length);
    }

}
