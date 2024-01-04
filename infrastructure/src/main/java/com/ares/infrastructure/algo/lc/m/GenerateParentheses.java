package com.ares.infrastructure.algo.lc.m;

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
        System.out.println(self(3));
    }

    private static List<String> self(int n) {
        List<String> ss = Lists.newArrayList();
        self(n, "", ss, 0, 0);
        return ss;
    }

    private static void self(int n, String s, List<String> collect, int lc, int rc) {
        if (lc > n || rc > lc) {
            return;
        }
        if (s.length() == n * 2) {
            collect.add(s);
            return;
        }
        self(n, s + "(", collect, lc + 1, rc);
        self(n, s + ")", collect, lc, rc + 1);
    }

}
