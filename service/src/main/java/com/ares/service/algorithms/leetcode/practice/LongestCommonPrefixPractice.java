package com.ares.service.algorithms.leetcode.practice;

/**
 * {@link com.ares.service.algorithms.leetcode.easy.LongestCommonPrefix} practice
 *
 * @author fansheng
 * @date 2021/7/30
 */
public class LongestCommonPrefixPractice {

    public static void main(String[] args) {
        System.out.println(method2(new String[]{"aba", "abb"}));
    }

    /**
     * 时间 O(mn)
     * 空间 O(1)
     */
    private static String method1(String[] strs) {
        String r = strs[0];
        for (int i = 1; i < strs.length; i++) {
            r = longestCommonPrefix(r, strs[i]);
            if (r.length() == 0) {
                break;
            }
        }
        return r;
    }

    private static String longestCommonPrefix(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < len && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    /**
     * 时间 O(mn)
     * 空间 O(1)
     */
    private static String method2(String[] strs) {
        String s = strs[0];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return s.substring(0, i);
                }
            }
        }
        return s;
    }

}
