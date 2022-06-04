package com.ares.service.algorithms.leetcode.hard;

/**
 * 10. 正则表达式匹配
 * https://leetcode.cn/problems/regular-expression-matching/
 * <p>
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖整个字符串 s 的，而不是部分字符串。
 * <p>
 * 示例 1：
 * 输入：s = "aa", p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * <p>
 * 示例 2:
 * 输入：s = "aa", p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * <p>
 * 示例 3：
 * 输入：s = "ab", p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * <p>
 * 提示：
 * 1 <= s.length <= 20
 * 1 <= p.length <= 30
 * s 只包含从 a-z 的小写字母。
 * p 只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 保证每次出现字符 * 时，前面都匹配到有效的字符
 *
 * @author fansheng
 * @date 2022/6/2
 */
public class RegularExpressionMatching {

    public static void main(String[] args) {
        System.out.println(algorithms1("ab", ".*.."));
    }

    private static boolean algorithms1(String s, String p) {
        // TODO 白写了，不对
        if (s.equals(p) || ".*".equals(p)) {
            return true;
        }
        int si = s.length() - 1;
        int pi = p.length() - 1;
        while (pi >= 0 && si >= 0) {
            char pc = p.charAt(pi);
            if (pc == '.' || pc == '*') {
                break;
            }
            char sc = s.charAt(si);
            if (sc != pc) {
                return false;
            }
            si--;
            pi--;
        }
        if (pi < 0) {
            return false;
        }
        p = p.substring(0, pi + 1);
        if (si < 0) {
            return matchEmpty(p);
        }
        s = s.substring(0, si + 1);
        int m = 0;
        int n = 0;
        char lastPc = '.';
        while (m <= si && n <= pi) {
            char sc = s.charAt(m);
            char pc = p.charAt(n);
            if (sc == pc || pc == '.') {
                if (pc == '.' && n < pi && p.charAt(n + 1) == '*') {
                    n += 2;
                    continue;
                }
                m++;
                n++;
                lastPc = pc;
                continue;
            }
            if (pc == '*') {
                if (lastPc != '.' && lastPc != sc) {
                    n++;
                    continue;
                }
            } else {
                if (n < pi) {
                    char nextSc = p.charAt(n + 1);
                    if (nextSc == '*') {
                        n += 2;
                        lastPc = '.';
                        continue;
                    }
                }
                return false;
            }
            m++;
        }
        if (n > pi && m > si) {
            return true;
        }
        if (n > pi) {
            return false;
        }
        return matchEmpty(p.substring(n));
    }

    private static boolean matchEmpty(String p) {
        boolean flag = false;
        for (char c : p.toCharArray()) {
            if (c != '*') {
                if (flag) {
                    return false;
                }
                flag = true;
            } else {
                flag = false;
            }
        }
        return !flag;
    }

}
