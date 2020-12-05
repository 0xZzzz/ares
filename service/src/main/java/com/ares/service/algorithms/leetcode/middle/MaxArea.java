package com.ares.service.algorithms.leetcode.middle;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 *
 * @author 0xZzzz
 * @date 2020/12/4
 */
public class MaxArea {

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
            if (height[r] > height[l]) {
                l++;
            } else {
                r--;
            }
        }
        System.out.println(maxArea);
    }

}
