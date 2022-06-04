package com.ares.service.algorithms.leetcode.practice;

/**
 * @author fansheng
 * @date 2022/5/30
 */
public class Practice {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 5, 6, 2, 5, 4, 8, 3, 5}));
    }

    public static int maxArea(int[] height) {
        int maxArea = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int ih = height[i];
            int jh = height[j];
            maxArea = Math.max(maxArea, (j - i) * Math.min(ih, jh));
            if (ih < jh) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }

}
