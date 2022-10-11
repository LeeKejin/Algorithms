package com.google.dp;

import java.util.Stack;

public class MaximalRectangle {
    /*
    O（m²n）
     */
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] width = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    width[i][j] = (j == 0 ? 1 : width[i][j - 1] + 1);
                } else {
                    continue;
                }
                int minWidth = width[i][j];
                for (int row = i; row >= 0; row--) {
                    int h = i - row + 1;
                    minWidth = Math.min(minWidth, width[row][j]);
                    res = Math.max(minWidth * h, res);
                }
            }
        }
        return res;
    }

    /*
O(MN)
     */
    public int maximalRectangleStack(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[j] += 1;
                } else {
                    dp[j] = 0;
                }
            }
            res = Math.max(res, cal(dp));
        }
        return res;
    }

    private int cal(int[] dp) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            while (stack.peek() != -1 && dp[stack.peek()] > dp[i]) {
                int h = dp[stack.pop()];
                int w = i - stack.peek() - 1;
                res = Math.max(res, h * w);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int h = dp[stack.pop()];
            int w = dp.length - stack.peek() - 1;
            res = Math.max(res, h * w);
        }
        return res;
    }
}
