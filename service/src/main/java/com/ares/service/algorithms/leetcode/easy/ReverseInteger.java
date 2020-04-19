package com.ares.service.algorithms.leetcode.easy;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *
 * 示例 2:
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * @author fansheng
 * @date 2020/4/19
 */
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(-321));
    }

    /**
     * 时间复杂度：O(log(x))
     * 空间复杂度：O(1)
     */
    private static int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        // 标记是否为负数
        int neg = x < 0 ? -1 : 1;
        // 把输入的数值转换为正数
        x *= neg;
        int ret = 0;
        while (x > 0) {
            int n = ret;
            n *= 10;
            n += x % 10;
            x /= 10;
            // 这里判断是否溢出，没有溢出这个等式一定是成立的，只有溢出之后这个等式才会不成立
            if (n / 10 != ret) {
                return 0;
            }
            ret = n;
        }
        return ret * neg;
    }

}
