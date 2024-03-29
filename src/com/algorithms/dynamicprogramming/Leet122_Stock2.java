package com.algorithms.dynamicprogramming;

public class Leet122_Stock2 {
    int[][] dp;

    //1->buy
    //0->sell
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) return 0;

        dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = 0 - prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }

    public int maxProfit1(int[] prices) {
        int profit = 0;
        int buy = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, profit + buy + prices[i]);
            buy = -prices[i];
        }
        return profit;
    }

    //Vally solution!
    public int maxProfitSolution2(int[] prices) {
        if (prices.length <= 1) return 0;

        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            int val = prices[i] - prices[i - 1];
            if (val > 0) {
                res += val;
            }
        }
        return res;

    }
}
