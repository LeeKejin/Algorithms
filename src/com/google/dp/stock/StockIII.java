package com.google.dp.stock;

public class StockIII {
    //0->buy
    public int maxProfit(int[] prices) {
        int dp[][][] = new int[prices.length][2][2];
        dp[0][0][0] = -prices[0];
        dp[0][0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0][0] = Math.max(dp[i - 1][0][0], -prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][0] + prices[i]);
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][1][0] - prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][1] + prices[i]);
        }
        return Math.max(dp[prices.length - 1][1][0], dp[prices.length - 1][1][1]);
    }

    public int maxProfit2(int[] prices) {
        int buy1 = -prices[0];
        int sell1 = 0;
        int buy2 = -prices[0];
        int sell2 = 0;
        for (int i = 1; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return Math.max(Math.max(sell1, sell2), 0);
    }

}
