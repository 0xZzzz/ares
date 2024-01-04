package com.ares.infrastructure.algo.string;

import java.util.Arrays;

/**
 * 检查字符串是否是字面相等的
 *
 * @author 0xZzzz
 */
public class AnagramCheck {

    public static void main(String[] args) {
        System.out.println(isAnagram("asdf", "afds"));
        System.out.println(iAnagram("hello", "holle"));
        System.out.println(checkAnagram("aafsd", "asfff"));
    }

    public static boolean isAnagram(String word, String anagram) {
        if (word.length() != anagram.length()) {
            return false;
        }
        char[] chars = word.toCharArray();
        for (char c : chars) {
            int index = anagram.indexOf(c);
            if (index == -1) {
                return false;
            }
            anagram = anagram.substring(0, index) + anagram.substring(index + 1);
        }
        return anagram.isEmpty();
    }

    /**
     * 都转换为char数组排序，然后数组之间进行equals比较
     */
    public static boolean iAnagram(String word, String anagram) {
        char[] charFromWord = word.toCharArray();
        char[] charFromAnagram = anagram.toCharArray();
        Arrays.sort(charFromWord);
        Arrays.sort(charFromAnagram);
        return Arrays.equals(charFromWord, charFromAnagram);
    }

    /**
     * 从第二个字符串中逐个删除第一个字符串char数组的元素，最后判断删除后的长度
     */
    public static boolean checkAnagram(String first, String second) {
        char[] characters = first.toCharArray();
        StringBuilder sbSecond = new StringBuilder(second);
        for (char ch : characters) {
            int index = sbSecond.indexOf(String.valueOf(ch));
            if (index == -1) {
                return false;
            }
            sbSecond.deleteCharAt(index);
        }
        return sbSecond.length() == 0;
    }
}