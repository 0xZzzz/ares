package com.ares.service.algorithms.lc.h;

/**
 * 4. 寻找两个正序数组的中位数
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/
 * <p>
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * <p>
 * 提示：
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 *
 * @author fansheng
 * @date 2022/5/30
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        System.out.println(algorithms(nums1, nums2));
    }

    private static double algorithms(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int mid = totalLength / 2;
        int p1 = 0;
        int p2 = 0;
        int start = 0;
        int end;
        int index = 0;
        while (true) {
            int m = p1 > nums1.length - 1 ? Integer.MAX_VALUE : nums1[p1];
            int n = p2 > nums2.length - 1 ? Integer.MAX_VALUE : nums2[p2];
            if (index == mid - 1) {
                start = Math.min(m, n);
            } else if (index == mid) {
                end = Math.min(m, n);
                break;
            }
            if (m < n && p1 <= nums1.length - 1 || p2 >= nums2.length) {
                p1++;
            } else {
                p2++;
            }
            index++;
        }
        return totalLength % 2 != 0 ? end : ((start + end) / 2.0);
    }
}