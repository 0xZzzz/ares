package com.ares.service.algorithms.leetcode.easy;

/**
 * leetcode 53 最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * @author  0xZzzz
 * @date 2020/5/3
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution1(nums));
        System.out.println(solution2(nums));
        System.out.println(solution3(nums));
    }

    /**
     * 暴力解法，枚举所有子序列，比较出最大的一个
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    private static int solution1(int[] nums) {
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int innerSum = nums[i];
            if (innerSum > maxSum) {
                maxSum = innerSum;
            }
            for (int j = i + 1; j < nums.length; j++) {
                innerSum += nums[j];
                if (innerSum > maxSum) {
                    maxSum = innerSum;
                }
            }
        }
        return maxSum;
    }

    /**
     * 原理：负数或者和为负数的序列不定不能成为最大子序列的左前缀
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int solution2(int[] nums) {
        int maxSum = nums[0];
        int pre = 0;
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxSum = Math.max(pre, maxSum);
        }
        return maxSum;
    }

    /**
     * 动态规划，遍历数组，只要数组中当前元素的前一个元素的值大于0，就将前一个元素的值累加到当前元素上
     * 最后找出修改后的数组中的最大值，即为数组中最大子序列的和
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int solution3(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
        }
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > maxSum) {
                maxSum = nums[i];
            }
        }
        return maxSum;
    }

    /**
     * 分治法：
     */
    public static int solution4(int[] nums) {
        return 0;
    }

}
