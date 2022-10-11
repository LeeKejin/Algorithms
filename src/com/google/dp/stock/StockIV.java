package com.google.dp.stock;

import java.util.Arrays;

public class StockIV {
    public int maxProfit(int k, int[] prices) {
        if (prices.length <= 1 || k <= 0) return 0;
        if (2 * k >= prices.length) {
            return unlimitedTransaction(prices);
        }
        int dp[][][] = new int[prices.length][2][k + 1];

        for (int j = 0; j <= k; j++) {
            dp[0][1][j] = -prices[0];
        }

        dp[0][0][0] = 0;
        dp[0][1][0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j <= k; j++) {
                if (j > 0) {
                    dp[i][0][j] = Math.max(dp[i - 1][0][j], dp[i - 1][1][j - 1] + prices[i]);
                }
                dp[i][1][j] = Math.max(dp[i - 1][1][j], dp[i - 1][0][j] - prices[i]);
            }
        }
        return Arrays.stream(dp[prices.length - 1][0]).max().getAsInt();
    }

    private int unlimitedTransaction(int[] prices) {
        int buy = -prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, profit + buy + prices[i]);
            buy = -prices[i];
        }
        return profit;
    }

    //vally
    private int unLimitedTransaction1(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                profit += (prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }

}
