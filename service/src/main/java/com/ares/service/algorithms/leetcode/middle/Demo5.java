package com.ares.service.algorithms.leetcode.middle;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * @author  0xZzzz
 * @date 2020/4/7
 */
public class Demo5 {

    public static void main(String[] args) {
        algorithms("aa");
        algorithms("asdabbadswaaa");
    }

    /**
     * 中心扩展算法，还有一个 Manacher 算法，用到了再了解吧
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    private static void algorithms(String seq) {
        int start = 0, end = 0;
        for (int i = 0; i < seq.length(); i++) {
            // 奇数回文从单个中心点开始  eg："aba"
            int len1 = expandAroundCenter(seq, i, i);
            // 偶数回文从两个中心点开始 eg："abba"
            int len2 = expandAroundCenter(seq, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        System.out.println(seq.substring(start, end + 1));
    }

    /**
     * 从中心点开始向两边扩展，两侧的值相等，证明是回文字符串
     */
    private static int expandAroundCenter(String seq, int left, int right) {
        int l = left, r = right;
        while (l >= 0 && r < seq.length() && seq.charAt(l) == seq.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

}
