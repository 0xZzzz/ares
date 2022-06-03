package com.ares.service.algorithms.leetcode.practice;

/**
 * @author fansheng
 * @date 2022/5/30
 */
public class Practice {

    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int t = x;
        int r = 0;
        while (t > 0) {
            r = r * 10 + t % 10 ;
            t /= 10;
        }
        return r == x;
    }

}
