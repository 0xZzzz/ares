package com.ares.infrastructure.algo.string;

/**
 * 查找给定字符串的所有序列。例如，给定一个字符串"XYZ"，程序将打印出所有可能得6个序列
 * eg：XYZ、XZY、YXZ、YZX、ZXY、ZYX
 *
 * @author 0xZzzz
 */
public class StringPermutations {

    public static void main(String[] args) {
        permutation("123");
    }

    public static void permutation(String input) {
        permutation("", input);
    }

    private static void permutation(String perm, String word) {
        if (word.isEmpty()) {
            System.err.println(perm + word);
        } else {
            for (int i = 0; i < word.length(); i++) {
                permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1));
            }
        }
    }
}