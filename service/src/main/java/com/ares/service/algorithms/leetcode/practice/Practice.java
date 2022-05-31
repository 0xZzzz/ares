package com.ares.service.algorithms.leetcode.practice;

/**
 * @author fansheng
 * @date 2022/5/30
 */
public class Practice {

    public static void main(String[] args) {
        String input = "pwwkew";
        String result = "";
        StringBuilder current = new StringBuilder();
        for (char c : input.toCharArray()) {
            String s = String.valueOf(c);
            if (current.indexOf(s) < 0) {
                current.append(s);
            } else if (current.length() > result.length()) {
                result = current.toString();
                current = new StringBuilder(s);
            }
        }
        System.out.println(result);
    }

}
