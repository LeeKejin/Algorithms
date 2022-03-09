package com.algorithms.dynamicprogramming;

public class Leet265 {
    public int minCostII(int[][] costs) {
        if (costs.length == 0) return 0;
        int m = costs.length;
        int n = costs[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = costs[m - 1][i];
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int price = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (k == j) continue;
                    price = Math.min(price, dp[i + 1][k]);
                }
                dp[i][j] = price + costs[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[0][i]);
        }
        return res;
    }

    public int minCostII1(int[][] costs) {

        int m = costs.length;
        int n = costs[0].length;
        int[][] dp = new int[m][n];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            dp[0][i] = costs[0][i];
            min = Math.min(min, costs[0][i]);
        }
        if (m == 1) return min;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int price = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (k == j) continue;
                    price = Math.min(dp[i - 1][k], price);
                }
                dp[i][j] = price + costs[i][j];
            }
        }
        min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(dp[m - 1][j], min);
        }
        return min;
    }
}
