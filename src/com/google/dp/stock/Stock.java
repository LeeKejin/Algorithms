package com.google.dp.stock;

public class Stock {
    public int maxProfit(int[] prices) {
        int buy = -prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] + buy);
            buy = Math.max(buy, -prices[i]);
        }
        return profit;
    }
}
