package com.ares.service.algorithms.leetcode.easy;

/**
 * @author fansheng
 * @date 2020/3/26
 */
public class Demo1 {

    public static void main(String[] args) {
        // 棋盘
        String[][] board = {
            {".", ".", ".", ".", ".", ".", ".", "."},
            {".", ".", ".", "p", ".", ".", ".", "."},
            {".", ".", ".", "R", ".", ".", ".", "p"},
            {".", ".", ".", ".", ".", ".", ".", "."},
            {".", ".", ".", ".", ".", ".", ".", "."},
            {".", ".", ".", "p", ".", ".", ".", "."},
            {".", ".", ".", ".", ".", ".", ".", "."},
            {".", ".", ".", ".", ".", ".", ".", "."}
        };
        algorithms(board);
    }

    /**
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     */
    private static void algorithms(String[][] board) {
        // 首先找到 R 的坐标
        int rx = -1, ry = -1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ("R".equals(board[i][j])) {
                    rx = j;
                    ry = i;
                    break;
                }
            }
        }
        System.out.println(rx + "," + ry);
        // 声明四个方向，例如 上：x + 1 y 不动，以此类推
        int[][] d = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        // 吃掉P的总数
        int cnt = 0;
        // 遍历四个方向
        for (int i = 0; i < 4; i++) {
            for (int step = 0; ; ++step) {
                // x 轴的移动是纵坐标的变化
                int tx = ry + d[i][1] * step;
                // y 轴的移动是横坐标的变化
                int ty = rx + d[i][0] * step;
                if (tx < 0 || tx >= 8 || ty < 0 || ty >= 8 || "B".equals(board[tx][ty])) {
                    break;
                }
                if ("p".equals(board[tx][ty])) {
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }

}
