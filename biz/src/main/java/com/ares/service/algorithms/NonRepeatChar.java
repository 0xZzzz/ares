package com.ares.service.algorithms;

import com.google.common.collect.Maps;

import java.util.*;
import java.util.Map.Entry;

/**
 * 在String中查找第一个非重复字符
 *
 * @author 0xZzzz
 */
public class NonRepeatChar {

    public static void main(String[] args) {
        System.out.println(getFirstNonRepeatedChar("abcdefghija"));
        System.out.println(firstNonRepeatingChar("java"));
        System.out.println(firstNonRepeatedCharacter("hello"));
    }

    /**
     * 使用LinkedHashMap查找String的第一个非重复字符
     * 算法 :
     * Step 1: 获取字符数组并循环遍历它以构建带有char及其计数的哈希表
     * Step 2: 循环遍历LinkedHashMap以查找值为1的项, 这是第一个非重复字符，因为LinkedHashMap维护插入顺序。
     */
    public static char getFirstNonRepeatedChar(String str) {
        Map<Character, Integer> counts = new LinkedHashMap<>(str.length());
        for (char c : str.toCharArray()) {
            counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
        }
        for (Entry<Character, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("didn't find any non repeated Character");
    }

    /**
     * 只需一次传递即可在String中查找第一个不重复的字符。
     * 它使用两个存储来减少一次迭代，标准的空间换时间。
     * 由于我们分别存储重复和非重复的字符，因此在迭代结束时，List中的第一个元素是String中的第一个非重复字符。
     */
    public static char firstNonRepeatingChar(String word) {
        Set<Character> repeating = new HashSet<>();
        List<Character> nonRepeating = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (repeating.contains(letter)) {
                continue;
            }
            if (nonRepeating.contains(letter)) {
                nonRepeating.remove((Character)letter);
                repeating.add(letter);
            } else {
                nonRepeating.add(letter);
            }
        }
        return nonRepeating.get(0);
    }

    /**
     * 使用HashMap寻找第一个不重复的字符
     * 算法 :
     * Step 1 : 扫描字符串并在HashMap中存储每个字符的计数
     * Step 2 : 遍历String并从Map获取每个字符的计数，直到任何一个计数为1的字符跳出循环。
     */
    public static char firstNonRepeatedCharacter(String word) {
        // char -> count
        HashMap<Character, Integer> scoreboard = Maps.newHashMap();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (scoreboard.containsKey(c)) {
                scoreboard.put(c, scoreboard.get(c) + 1);
            } else {
                scoreboard.put(c, 1);
            }
        }
        // 因为HashMap不维护顺序，所以再次遍历字符串
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (scoreboard.get(c) == 1) {
                return c;
            }
        }
        throw new RuntimeException("Undefined behaviour");
    }
}
