package com.ares.service.algorithms.array;

/**
 * 最小子序列问题
 *
 * @author fansheng
 * @since 2019/11/1
 */
public class MinimumSubSequenceDemo {

    public static void main(String[] args) {
        int[] arr = {-12, 11, -4, 13, -5, -8};
        System.out.println(m3(arr, 0, arr.length - 1));
    }

    /**
     * 方法1，时间复杂度O(n^3)
     */
    private static void m1(int[] arr) {
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int innerSum = 0;
                StringBuilder seq = new StringBuilder();
                for (int k = i; k <= j; k++) {
                    seq.append(arr[k]).append(" + ");
                    innerSum += arr[k];
                }
                seq.delete(seq.length() - 3, seq.length()).append(" = ").append(innerSum);
                System.out.println(seq.toString());
                if (innerSum > maxSum) {
                    maxSum = innerSum;
                }
            }
        }
        System.out.println(maxSum);
    }

    /**
     * 方法2，时间复杂度O(n^2)
     */
    private static void m2(int[] arr) {
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int innerSum = 0;
            for (int j = i; j < arr.length; j++) {
                innerSum += arr[j];
                if (innerSum > maxSum) {
                    maxSum = innerSum;
                }
            }
        }
        System.out.println(maxSum);
    }

    /**
     * 方法3，分治法，时间复杂度O(n log n)
     */
    private static int m3(int[] arr, int left, int right) {
        /*
         * 分治法，递归
         * 将数组分成两部分，分别递归求两部分的最大子序列，最后与包含两部分边界值的最大子序列进行比较，求出最大子序列
         */
        if (left == right) {
            if (arr[left] > 0) {
                return arr[left];
            }
            return 0;
        }
        int center = (left + right) / 2;
        int maxLeftSum = m3(arr, left, center);
        int maxRightSum = m3(arr, center + 1, right);
        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for (int i = center; i >= left; i--) {
            leftBorderSum += arr[i];
            if (leftBorderSum > maxLeftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }

        int maxRightBorderSum = 0, rightBorderSum = 0;
        for (int i = center + 1; i <= right; i++) {
            rightBorderSum += arr[i];
            if (rightBorderSum > maxRightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }
        int maxCenterSum = maxLeftBorderSum + maxRightBorderSum;
        if (maxLeftSum > maxRightSum) {
            if (maxLeftSum > maxCenterSum) {
                return maxLeftSum;
            }
            return maxCenterSum;
        }
        if (maxRightSum > maxCenterSum) {
            return maxRightSum;
        }
        return maxCenterSum;
    }

    /**
     * 方法4，时间复杂度O(n)
     */
    private static void m4(int[] arr) {
        /*
         * 如果arr[i]是负数，那么它不可能代表最优序列的起点，同样的，任何负的子序列不可能是最优子序列的前缀
         */
        int maxSum = 0;
        int innerSum = 0;
        for (int a : arr) {
            innerSum += a;
            if (innerSum > maxSum) {
                maxSum = innerSum;
            } else if (innerSum < 0) {
                innerSum = 0;
            }
        }
        System.out.println(maxSum);
    }

}
