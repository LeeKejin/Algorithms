package com.algorithms.dynamicprogramming;

import java.util.Arrays;

public class Leet188_Stock4 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || prices.length == 1 || k == 0) return 0;
        int[][][] dp = new int[prices.length][k + 1][2];
        k = Math.min(k, prices.length / 2);
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j][1] = -1000000000;
            }
        }
        dp[0][1][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            for (int j = k; j >= 0; j--) {

                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);

                if (j > 0) {
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                }

            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= k; i++) {
            max = Math.max(dp[prices.length - 1][i][0], max);
        }
        return max;
    }

    //https://www.youtube.com/watch?v=6928FkPhGUA
    public int maxProfitDP(int k, int[] prices) {
        if (prices.length <= 1 || k == 0) return 0;

        //unlimited transactions
        if (2 * k >= prices.length) {
            int res = 0;
            for (int i = 1; i < prices.length; i++) {
                int val = prices[i] - prices[i - 1];
                if (val > 0) {
                    res += val;
                }
            }
            return res;
        }
        //limited transaction
        int length = 2 * k;
        int dp[] = new int[length];
        dp[0] = Integer.MIN_VALUE;
        //even number for buy stock, odd number for sell
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) dp[i] = Integer.MIN_VALUE;
        }
        //for each element do 2k operations
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < length; j++) {
                if (j == 0) dp[j] = Math.max(dp[j], 0 - prices[i]);
                    //Buy status
                else if (j % 2 == 0) {
                    dp[j] = Math.max(dp[j], dp[j - 1] - prices[i]);
                }
                //Sell status
                else if (j % 2 == 1) {
                    dp[j] = Math.max(dp[j], dp[j - 1] + prices[i]);
                }
            }
        }
        return dp[length - 1];
    }

    public int maxProfit1(int k, int[] prices) {
        if (prices.length <= 1 || k <= 0) return 0;
        if (2 * k >= prices.length) {
            return unlimitedTransaction(prices);
        }
        int dp[][][] = new int[prices.length][2][k + 1];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][1][j] = -1000000;
            }
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

    public static void main(String[] args) {
        Leet188_Stock4 test = new Leet188_Stock4();
        test.maxProfitDP(2, new int[]{3, 2, 6, 5, 0, 3});
    }
}
