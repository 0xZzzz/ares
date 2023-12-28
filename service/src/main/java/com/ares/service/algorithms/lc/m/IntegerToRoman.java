package com.ares.service.algorithms.lc.m;

/**
 * 12. 整数转罗马数字
 * https://leetcode.cn/problems/integer-to-roman/
 *
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * <p>
 * 例如， 罗马数字 2 写做 II，即为两个并列的 1。12 写做 XII，即为 X + II。 27 写做 XXVII, 即为 XX + V + II。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * 输入: 3
 * 输出: "III"
 * <p>
 * 示例 2:
 * 输入: 4
 * 输出: "IV"
 * <p>
 * 示例 3:
 * 输入: 9
 * 输出: "IX"
 * <p>
 * 示例 4:
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * <p>
 * 示例 5:
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * @author  0xZzzz
 * @date 2020/12/7
 */
public class IntegerToRoman {

    private static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] SYMBOLS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static void main(String[] args) {
        int num = 1994;
        algorithms1(num);
        algorithms2(num);
    }

    /**
     * 时间复杂度：O(1)。由于有一组有限的罗马数字，循环可以迭代多少次有一个硬上限。因此，我们说时间复杂度是常数的，即 O(1)。
     * 空间复杂度：O(1)，使用的内存量不会随输入整数的大小而改变，因此是常数的。
     */
    private static void algorithms1(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < VALUES.length; i++) {
            int value = VALUES[i];
            if (num == value) {
                sb.append(SYMBOLS[i]);
                break;
            }
            if (num > value) {
                for (int j = 0; j < num / value; j++) {
                    sb.append(SYMBOLS[i]);
                }
                num %= value;
            }
        }
        System.out.println(sb);
    }

    /**
     * 时间复杂度：O(1)。由于有一组有限的罗马数字，循环可以迭代多少次有一个硬上限。因此，我们说时间复杂度是常数的，即 O(1)。
     * 空间复杂度：O(1)，使用的内存量不会随输入整数的大小而改变，因此是常数的。
     */
    private static void algorithms2(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < VALUES.length && num > 0; i++) {
            int value = VALUES[i];
            while (num >= value) {
                sb.append(SYMBOLS[i]);
                num -= value;
            }
        }
        System.out.println(sb);
    }

}
