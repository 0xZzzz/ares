package com.ares.service.algorithms.leetcode.middle;

import java.util.Arrays;

/**
 * 有效括号字符串 定义：对于每个左括号，都能找到与之对应的右括号，反之亦然。详情参见题末「有效括号字符串」部分。
 *
 * 嵌套深度 depth 定义：即有效括号字符串嵌套的层数，depth(A) 表示有效括号字符串 A 的嵌套深度。详情参见题末「嵌套深度」部分。
 *
 * 给你一个「有效括号字符串」 seq，请你将其分成两个不相交的有效括号字符串，A 和 B，并使这两个字符串的深度最小。
 *
 * 不相交：每个 seq[i] 只能分给 A 和 B 二者中的一个，不能既属于 A 也属于 B 。
 * A 或 B 中的元素在原字符串中可以不连续。
 * A.length + B.length = seq.length
 * 深度最小：max(depth(A), depth(B)) 的可能取值最小。 
 * 划分方案用一个长度为 seq.length 的答案数组 answer 表示，编码规则如下：
 *
 * answer[i] = 0，seq[i] 分给 A 。
 * answer[i] = 1，seq[i] 分给 B 。
 * 如果存在多个满足要求的答案，只需返回其中任意 一个 即可。
 *
 * 示例 1：
 *
 * 输入：seq = "(()())"
 * 输出：[0,1,1,1,1,0]
 *
 * 示例 2：
 *
 * 输入：seq = "()(())()"
 * 输出：[0,0,0,1,1,0,1,1]
 * 解释：本示例答案不唯一。
 * 按此输出 A = "()()", B = "()()", max(depth(A), depth(B)) = 1，它们的深度最小。
 * 像 [1,1,1,0,0,1,1,1]，也是正确结果，其中 A = "()()()", B = "()", max(depth(A), depth(B)) = 1 。
 *
 * @author  0xZzzz
 * @date 2020/4/1
 */
public class Demo3 {

    public static void main(String[] args) {
        algorithms("()(())()((()))");
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 算上结果数组 O(n) 不算结果数组 O(1)
     */
    public static void algorithms(String seq) {
        int len = seq.length();
        int[] res = new int[len];

        // 嵌套深度，栈的当前高度
        int depth = 0;

        // 在 Java 里，seq.charAt(i) 函数会做下标越界检查，
        // 因此先转换成字符数组是常见的做法
        char[] charArray = seq.toCharArray();

        for (int i = 0; i < len; i++) {
            // 遍历到左括号，连续括号个数加 1，
            if (charArray[i] == '(') {
                depth++;
                // % 2 也可以写成 & 1，为了保证语义清楚，写 % 2
                res[i] = depth % 2;
            } else {
                // 遍历到右括号，与当前栈顶左括号分在一组，因此先取模，再 --
                // 这一步希望大家多体会，很有意思
                res[i] = depth % 2;
                depth--;
            }
        }
        System.out.println(Arrays.toString(res));
    }

}
