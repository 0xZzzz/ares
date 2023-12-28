package com.ares.service.algorithms.lc.m;

/**
 * 11. 盛最多水的容器
 * https://leetcode.cn/problems/container-with-most-water/
 *
 * 给定一个长度为 n 的整数数组 height。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i])。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 *
 * @author 0xZzzz
 * @date 2020/12/4
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        algorithms1(height);
        algorithms2(height);
    }

    /**
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     */
    private static void algorithms1(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
            }
        }
        System.out.println(maxArea);
    }

    /**
     * 双指针
     *
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public static void algorithms2(int[] height) {
        int maxArea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxArea = Math.max(maxArea, (r - l) * Math.min(height[l], height[r]));
            /*
             * 这里其实可以再加一个判断，如果两边指针的高度相等时，可以同时向内移动，因为对于这两个指针构成的面积来说，
             * 无论哪边向内移动，都不可能再出现面积比当前面积更大的情况，高度是固定的，但是x轴的长度却在减小
             */
            if (height[r] > height[l]) {
                l++;
            } else {
                r--;
            }
        }
        System.out.println(maxArea);
    }

}
