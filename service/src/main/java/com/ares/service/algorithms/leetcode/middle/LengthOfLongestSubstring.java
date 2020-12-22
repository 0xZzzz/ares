package com.ares.service.algorithms.leetcode.middle;

import com.google.common.collect.Maps;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * leetcode 3
 *
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是子串的长度，"pwke" 是一个子序列，不是子串。
 * @author  0xZzzz
 * @date 2020/3/30
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        algorithms1("abcabcbb");
        algorithms1("bbbbb");
        algorithms1("pwwkew");

        algorithms2("abcabcbb");
        algorithms2("bbbbb");
        algorithms2("pwwkew");

        algorithms3("abcabcbb");
        algorithms3("bbbbb");
        algorithms3("pwwkew");
    }

    /**
     * 暴力解法，枚举所有的字符串，看是否包含重复字符，进行长度判断
     *
     * 时间复杂度 O(n^3)
     * 空间复杂度 O(n)
     */
    private static void algorithms1(String str) {
        int len = str.length();
        int maxLength = 0;
        String maxStr = null;
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (maxLength == 0) {
                maxLength = 1;
                maxStr = String.valueOf(c);
            }
            StringBuilder seq = new StringBuilder(String.valueOf(c));
            for (int j = i + 1; j < len; j++) {
                seq.append(str.charAt(j));
                String seqStr = seq.toString();
                if (hasRepeatedChar(seqStr)) {
                    break;
                }
                if (seqStr.length() > maxLength) {
                    maxLength = seqStr.length();
                    maxStr = seqStr;
                }
            }
        }
        System.out.println(maxStr + ", " + maxLength);
    }

    /**
     * 是否含有重复的字符
     */
    private static boolean hasRepeatedChar(String str) {
        Set<Character> set = new HashSet<>(str.length());
        for (char c : str.toCharArray()) {
            set.add(c);
        }
        return set.size() != str.length();
    }

    /**
     * 滑动窗口，什么是滑动窗口？
     *
     * 其实就是一个队列,比如例题中的 abcabcbb，进入这个队列（窗口）为 abc 满足题目要求，
     * 当再进入 a，队列变成了 abca，这时候不满足要求。所以，我们要移动这个队列！
     * 如何移动？
     * 我们只要把队列的左边的元素移出就行了，直到满足题目要求！
     * 一直维持这样的队列，找出队列出现最长的长度时候，求出解！
     *
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    private static void algorithms2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        System.out.println(ans);
    }

    /**
     * 优化的滑动窗口
     * 上述的方法最多需要执行 2n 个步骤。事实上，它可以被进一步优化为仅需要 n 个步骤。
     * 我们可以定义字符到索引的映射，而不是使用集合来判断一个字符是否存在。当我们找到重复的字符时，我们可以立即跳过该窗口。
     *
     * 也就是说，如果 s[j] 在 [i,j) 范围内有与 j' 重复的字符，我们不需要逐渐增加 i。
     * 我们可以直接跳过 [i，j'] 范围内的所有元素，并将 i 变为 j' + 1
     */
    private static void algorithms3(String s) {
        int n = s.length();
        Map<Character, Integer> map = Maps.newHashMap();
        int ans = 0;
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        System.out.println(ans);
    }

}
