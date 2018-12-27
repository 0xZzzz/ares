package com.ares.service.algorithms.string;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Set;

/**
 * 查找字符串中的重复字符，并打印出来，要打印出重复的次数
 *
 * @author 0xZzzz
 * @since 2018/12/27
 */
public class FindDuplicateCharacters {

    public static void main(String[] args) {
        printDuplicateCharacters("Programming");
        printDuplicateCharacters("Combination");
        printDuplicateCharacters("Java");
    }

    public static void printDuplicateCharacters(String word) {
        char[] characters = word.toCharArray();
        // 字符 --> 字符出现的次数
        Map<Character, Integer> charMap = Maps.newHashMap();
        for (Character ch : characters) {
            if (charMap.containsKey(ch)) {
                charMap.put(ch, charMap.get(ch) + 1);
            } else {
                charMap.put(ch, 1);
            }
        }
        // 打印
        Set<Map.Entry<Character, Integer>> entrySet = charMap.entrySet();
        System.out.printf("List of duplicate characters in String '%s' %n", word);
        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (entry.getValue() > 1) {
                System.out.printf("%s : %d %n", entry.getKey(), entry.getValue());
            }
        }
    }
}