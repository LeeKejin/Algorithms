package com.google.dp;

public class Leet1937 {
    public long maxPoints(int[][] points) {
        long res = Integer.MIN_VALUE;
        int m = points.length;
        int n = points[0].length;
        long dp[][] = new long[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = points[0][i];
            res = Math.max(res, dp[0][i]);
        }
        if (m == 1) return res;
        for (int i = 1; i < m; i++) {
            long leftMax = 0;
            for (int j = 0; j < n; j++) {
                leftMax = Math.max(leftMax - 1, dp[i - 1][j]);
                dp[i][j] = leftMax;
            }
            long rightMax = 0;
            for (int j = n - 1; j >= 0; j--) {
                rightMax = Math.max(rightMax - 1, dp[i - 1][j]);
                dp[i][j] = Math.max(dp[i][j], rightMax) + points[i][j];
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
