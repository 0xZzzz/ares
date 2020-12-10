package com.ares.service.algorithms.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 基数排序
 *
 * @author  0xZzzz
 * @date 2020/3/26
 */
public class RadixSort {

    public static void main(String[] args) {

    }

    public static void radixSort(int[] input) {
        final int radix = 10;
        // declare and initialize bucket[]
        List<Integer>[] bucket = new ArrayList[radix];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }
        // sort
        boolean maxLength = false;
        int tmp = -1, placement = 1;
        while (!maxLength) {
            maxLength = true;
            // split input between lists
            for (Integer i : input) {
                tmp = i / placement;
                bucket[tmp % radix].add(i);
                if (maxLength && tmp > 0) {
                    maxLength = false;
                }
            }
            // empty lists into input array
            int a = 0;
            for (int b = 0; b < radix; b++) {
                for (Integer i : bucket[b]) {
                    input[a++] = i;
                }
                bucket[b].clear();
            }
            // move to next digit
            placement *= radix;
        }
    }
}
