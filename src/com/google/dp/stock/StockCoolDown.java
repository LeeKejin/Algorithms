package com.google.dp.stock;

public class StockCoolDown {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (i - 2 > 0) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][1] - prices[i]);
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            }
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }
}
