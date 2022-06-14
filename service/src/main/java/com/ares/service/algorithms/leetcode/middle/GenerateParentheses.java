package com.ares.service.algorithms.leetcode.middle;

import org.apache.commons.compress.utils.Lists;

import java.util.List;

/**
 * 22. 括号生成
 * https://leetcode.cn/problems/generate-parentheses/
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 *
 * 提示：
 * 1 <= n <= 8
 *
 * @author fansheng
 * @date 2022/6/11
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        List<String> ss = Lists.newArrayList();
        all(6, "", ss);
        System.out.println(ss);
    }

    private static void all(int n, String s, List<String> collect) {
        String s1 = s + "(";
        String s2 = s + ")";
        if (s1.length() == n) {
            collect.add(s1);
            collect.add(s2);
            return;
        }
        all(n, s1, collect);
        all(n, s2, collect);
    }

}
