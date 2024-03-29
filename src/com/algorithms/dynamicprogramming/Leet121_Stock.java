package com.algorithms.dynamicprogramming;

public class Leet121_Stock {
    int[][] dp;

    //1->buy
    //0->sell
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) return 0;

        dp = new int[prices.length][2];

        dp[0][0] = 0;
        dp[0][1] = 0 - prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(prices[i] + dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = Math.max(0 - prices[i], dp[i - 1][1]);
        }

        return dp[prices.length - 1][0];
    }

    public int maxProfit1(int[] prices) {
        int buy = -prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] + buy);
            buy = Math.max(buy, -prices[i]);
        }
        return profit;
    }
}
