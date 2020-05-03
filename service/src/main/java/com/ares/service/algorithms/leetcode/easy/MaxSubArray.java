package com.ares.service.algorithms.leetcode.easy;

/**
 * leetcode 53 最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * @author fansheng
 * @date 2020/5/3
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution1(nums));
    }

    /**
     * 暴力解法，枚举所有子序列，比较出最大的一个
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    private static int solution1(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
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

    private static int solution2(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        return maxSum;
    }

}
