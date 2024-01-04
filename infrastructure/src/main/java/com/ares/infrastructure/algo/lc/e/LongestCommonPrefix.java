package com.ares.infrastructure.algo.lc.e;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 14. 最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 *
 * @author 0xZzzz
 * @date 2020/12/10
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        algorithms1(strs);
        algorithms2(strs);
        algorithms3(strs);
    }

    /**
     * 横向扫描
     * 时间复杂度：O(mn) 其中 m 是字符串数组中的字符串的平均长度，n 是字符串的数量。最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
     * 空间复杂度：O(1)
     */
    private static void algorithms1(String[] strs) {
        if (ArrayUtils.isEmpty(strs)) {
            System.out.println("字符串数组为空");
            return;
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (StringUtils.isBlank(prefix)) {
                break;
            }
        }
        System.out.println(prefix);
    }

    /**
     * 通过比较两个字符串的每一个下标的字符是否相等来找到最长公共前缀
     */
    private static String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    /**
     * 纵向扫描
     * 时间复杂度：O(mn)，其中 m 是字符串数组中的字符串的平均长度，n 是字符串的数量。最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
     * 空间复杂度：O(1)
     */
    private static void algorithms2(String[] strs) {
        if (ArrayUtils.isEmpty(strs)) {
            System.out.println("字符串数组为空");
            return;
        }
        String firstStr = strs[0];
        int length = firstStr.length();
        int count = strs.length;
        // 以第一个字符串为基准，遍历每一个字符进行比较
        for (int i = 0; i < length; i++) {
            char c = firstStr.charAt(i);
            for (int j = 1; j < count; j++) {
                // 遍历数组中剩余的字符串，比较对应下标的字符是否相等
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    System.out.println(firstStr.substring(0, i));
                    return;
                }
            }
        }
        System.out.println(firstStr);
    }

    /**
     * 分治法
     * 时间复杂度：O(mn)，其中 m 是字符串数组中的字符串的平均长度，n 是字符串的数量。
     * 空间复杂度：O(m log n)，其中 m 是字符串数组中的字符串的平均长度，n 是字符串的数量。空间复杂度主要取决于递归调用的层数，层数最大为 log n，每层需要 m 的空间存储返回结果。
     */
    private static void algorithms3(String[] strs) {
        if (ArrayUtils.isEmpty(strs)) {
            System.out.println("字符串数组为空");
            return;
        }
        System.out.println(longestCommonPrefix(strs, 0, strs.length - 1));
    }

    private static String longestCommonPrefix(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        } else {
            int mid = (end - start) / 2 + start;
            String lcpLeft = longestCommonPrefix(strs, start, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, end);
            return longestCommonPrefix(lcpLeft, lcpRight);
        }
    }

    /**
     * 二分查找算法
     * 时间复杂度：O(mn log m)，其中 m 是字符串数组中的字符串的最小长度，n 是字符串的数量。二分查找的迭代执行次数是 O(log m)，每次迭代最多需要比较 mn 个字符，因此总时间复杂度是 O(mn log m)
     * 空间复杂度：O(1)
     */
    public static void algorithms4(String[] strs) {
        if (ArrayUtils.isEmpty(strs)) {
            System.out.println("字符串数组为空");
            return;
        }
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        int low = 0, high = minLength;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (isCommonPrefix(strs, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(strs[0].substring(0, low));
    }

    private static boolean isCommonPrefix(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            String str = strs[i];
            for (int j = 0; j < length; j++) {
                if (str0.charAt(j) != str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

}
