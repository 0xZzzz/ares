package com.ares.service.algorithms.leetcode.easy;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 给定一副牌，每张牌上都写着一个整数。
 *
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 *
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 *
 * 示例 1：
 * 输入：[1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 *
 * 示例 2：
 * 输入：[1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 *
 * 示例 3：
 * 输入：[1]
 * 输出：false
 * 解释：没有满足要求的分组。
 *
 * 示例 4：
 * 输入：[1,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]
 *
 * 示例 5：
 * 输入：[1,1,2,2,2,2]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[2,2]
 *
 * 提示：
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] < 10000
 *
 * @author  0xZzzz
 * @date 2020/3/27
 */
public class Demo3 {

    public static void main(String[] args) {
        int[] deck = {1, 2, 3, 4, 4, 3, 2, 1};
        algorithms1(deck);
        algorithms2(deck);
    }

    /**
     * 时间复杂度 O(n) 空间复杂度 O(n)
     */
    private static void algorithms1(int[] deck) {
        Map<Integer, Integer> map = Maps.newHashMap();
        for (int i : deck) {
            map.merge(i, 1, Integer::sum);
        }
        int x = -1;
        for (Integer size : map.values()) {
            if (size < 2) {
                System.out.println(false);
                return;
            }
            if (x < 2) {
                x = size;
                continue;
            }
            if (size != x) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }

    /**
     * 时间复杂度：O(n log c)，其中 n 是卡牌的个数，c 是数组 deck 中数的范围
     * 空间复杂度：O(n)
     */
    private static void algorithms2(int[] deck) {
        int[] sum = new int[10000];
        for (int i : deck) {
            sum[i]++;
        }
        int g = -1;
        for (int i = 0; i < 10000; i++) {
            if (sum[i] > 0) {
                if (g == -1) {
                    g = sum[i];
                } else {
                    g = gcd(g, sum[i]);
                }
            }
        }
        System.out.println(g >= 2);
    }

    /**
     * 求最大公约数，时间复杂度 O(log c)
     */
    private static int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }

}
