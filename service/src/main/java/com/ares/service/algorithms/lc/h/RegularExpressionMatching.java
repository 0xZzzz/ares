package com.ares.service.algorithms.lc.h;

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

    /**
     * 动态规划
     * 时间复杂度：O(mn)，其中 m 和 n 分别是字符串 s 和 p 的长度。我们需要计算出所有的状态，并且每个状态在进行转移时的时间复杂度为 O(1)。
     * 空间复杂度：O(mn)，即为存储所有状态使用的空间。
     */
    private static boolean algorithms1(String s, String p) {
        int m = s.length();
        int n = p.length();
        // 表示s的前i个字符能否和p的前j个字符匹配
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    private static boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    private static boolean self(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int sl = s.length();
        int pl = p.length();
        // 表示s的前i个字符能否和p的前j个字符匹配，默认全部为false
        boolean[][] dp = new boolean[sl + 1][pl + 1];
        dp[0][0] = true;

        // 初始化dp二维数组的第一列，此时s的位置是0，代表空串
        // 如果p的第j-1个位置是*，则j的状态等于j-2的状态
        for (int j = 1; j <= pl; j++) {
            // 情况1: 如果p的第j-1个位置是*，则j的状态等于j-2的状态
            // 例如：s='' p='a*' 相当于p向前看2个位置如果匹配，则*相当于重复0个字符
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= sl; i++) {
            for (int j = 1; j <= pl; j++) {
                /*
                 * 情况2: 如果s和p当前字符是相等的 或者p当前位置是. 则当前的dp[i][j] 可由dp[i - 1][j - 1]转移过来
                 * 当前位置相匹配，则s和p都向前看一位 如果前面所有字符相匹配 则当前位置前面的所有字符也匹配
                 * 例如：s='XXXa' p='XXX.' 或者 s='XXXa' p='XXXa'
                 */
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    /*
                     * 情况3: 进入当前字符不匹配的分支 如果当前p是* 则有可能会匹配
                     * s当前位置和p前一个位置相同 或者p前一个位置等于. 则有三种可能
                     * 其中一种情况能匹配 则当前位置的状态也能匹配
                     * dp[i][j - 2]：p向前看2个位置，相当于*重复了0次，
                     * dp[i][j - 1]：p向前看1个位置，相当于*重复了1次
                     * dp[i - 1][j]：s向前看一个位置，相当于*重复了n次
                     * 例如 s='XXXa' p='XXXa*'
                     */
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j];
                    } else {
                        /*
                         * 情况4: s当前位置和p前2个位置不匹配，则相当于*重复了0次
                         * 例如 s='XXXb' p='XXXa*' 当前位置的状态和p向前看2个位置的状态相同
                         */
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[sl][pl];
    }

}
