package com.ares.service.algorithms.lc.m;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * https://leetcode.cn/problems/4sum/
 * <p>
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * <p>
 * 示例 2：
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 * <p>
 * 提示：
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 *
 * @author fansheng
 * @date 2022/6/2
 */
public class FourSum {

    public static void main(String[] args) {
        System.out.println(algorithms1(new int[]{2, 2, 2, 2}, 8));
    }

    private static List<List<Integer>> algorithms1(int[] nums, int target) {
        Arrays.sort(nums);
        int l = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < l; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int t = target - nums[i] - nums[j];
                int end = l - 1;
                for (int k = j + 1; k < l; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    while (end > k && nums[end] + nums[k] > t) {
                        end--;
                    }
                    if (k == end) {
                        break;
                    }
                    if (nums[end] + nums[k] == t) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[end]);
                        ans.add(list);
                    }
                }
            }
        }
        return ans;
    }

}
