package com.ares.service.algorithms.lc.m;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 6. Z 字形变换
 * https://leetcode.cn/problems/zigzag-conversion/
 * <p>
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * <p>
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * 示例 1: 输入: s = "LEETCODEISHIRING", numRows = 3 输出: "LCIRETOESIIGEDHN"
 * <p>
 * 示例 2: 输入: s = "LEETCODEISHIRING", numRows = 4 输出: "LDREOEIIECIHNTSG" 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * @author 0xZzzz
 * @date 2020/4/12
 */
public class ZigZagConversion {

    public static void main(String[] args) {
        convert1("LEETCODEISHIRING", 3);
        convert2("LEETCODEISHIRING", 3);
    }

    /**
     * 时间复杂度：O(n) 空间复杂度：O(n)
     */
    private static void convert1(String s, int numRows) {
        if (numRows == 1) {
            return;
        }

        List<StringBuilder> rows = new ArrayList<>();
        // 初始化每行的字符串
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        // 行数的方向，向上 or 向下
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            // 当行数是第一行或者最后一行时，下一行的方向就要向反方向移动了
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        System.out.println(ret);
    }

    /**
     * 时间复杂度：O(n) 空间复杂度：O(n)
     * 这个没懂，需要研究下
     */
    private static void convert2(String s, int numRows) {
        if (numRows == 1) {
            return;
        }
        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                    ret.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        System.out.println(ret);
    }

    public static void self(String s, int rows) {
        int currentRow = 0;
        boolean down = true;
        String[] arr = new String[rows];
        for (char c : s.toCharArray()) {
            String rowString = arr[currentRow];
            if (rowString == null) {
                rowString = String.valueOf(c);
            } else {
                rowString += String.valueOf(c);
            }
            arr[currentRow] = rowString;
            if (down) {
                currentRow++;
                if (currentRow == rows - 1) {
                    down = false;
                }
            } else {
                currentRow--;
                if (currentRow == 0) {
                    down = true;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        Arrays.stream(arr).forEach(result::append);
        System.out.println(result);
    }

}
