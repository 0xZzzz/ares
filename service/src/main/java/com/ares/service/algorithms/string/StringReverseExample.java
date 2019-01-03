package com.ares.service.algorithms.string;

/**
 * String反转
 *
 * @author 0xZzzz
 * @since 2019/01/03
 */
public class StringReverseExample {

    public static void main(String[] args) {

        // original string
        String str = "Sony is going to introduce Internet TV soon";
        System.out.println("Original String: " + str);

        // reversed string using StringBuilder
        String reverseStr = new StringBuilder(str).reverse().toString();
        System.out.println("Reverse String in Java using StringBuilder: " + reverseStr);

        // iterative method to reverse String in Java
        reverseStr = reverse(str);
        System.out.println("Reverse String in Java using Iteration: " + reverseStr);

        // recursive method to reverse String in Java
        reverseStr = reverseRecursively(str);
        System.out.println("Reverse String in Java using Recursion: " + reverseStr);

    }

    /**
     * 转换为char数组，然后从尾部遍历，重新拼接
     */
    public static String reverse(String str) {
        StringBuilder strBuilder = new StringBuilder();
        char[] strChars = str.toCharArray();

        for (int i = strChars.length - 1; i >= 0; i--) {
            strBuilder.append(strChars[i]);
        }

        return strBuilder.toString();
    }

    /**
     * 递归每次截取第一个字符，拼接到最后
     */
    public static String reverseRecursively(String str) {

        // base case to handle one char string and empty string
        if (str.length() < 2) {
            return str;
        }

        return reverseRecursively(str.substring(1)) + str.charAt(0);

    }
}