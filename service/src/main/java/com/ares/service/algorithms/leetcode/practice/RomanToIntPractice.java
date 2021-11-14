package com.ares.service.algorithms.leetcode.practice;

/**
 * {@link com.ares.service.algorithms.leetcode.easy.RomanToInt} practice
 *
 * @author fansheng
 * @date 2021/7/23
 */
public class RomanToIntPractice {

    private static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] SYMBOLS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static void main(String[] args) {
        String roman = "LVIII";
        romainToInt(roman);
    }

    private static void romainToInt(String roman) {
        int r = 0;
        for (int i = 0; i < SYMBOLS.length; i++) {
            String s = SYMBOLS[i];
            while (roman.startsWith(s)) {
                r += VALUES[i];
                roman = roman.substring(s.length());
            }
        }
        System.out.println(r);
    }

}
