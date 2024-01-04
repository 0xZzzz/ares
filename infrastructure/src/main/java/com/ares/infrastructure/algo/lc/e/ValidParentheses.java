package com.ares.infrastructure.algo.lc.e;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 20. 有效的括号
 * https://leetcode.cn/problems/valid-parentheses/
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 1. 左括号必须用相同类型的右括号闭合。
 * 2. 左括号必须以正确的顺序闭合。
 *
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 *
 * 示例 4：
 * 输入：s = "([)]"
 * 输出：false
 *
 * 示例 5：
 * 输入：s = "{[]}"
 * 输出：true
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 *
 * @author fansheng
 * @date 2022/6/2
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(algorithms1("()[]{}"));
    }

    private static boolean algorithms1(String str) {
        if (str.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> pairs = new HashMap<Character, Character>() {
            {
                put('}', '{');
                put(']', '[');
                put(')', '(');
            }
        };
        Deque<Character> stack = new LinkedList<>();
        for (char c : str.toCharArray()) {
            if (pairs.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != pairs.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

}
