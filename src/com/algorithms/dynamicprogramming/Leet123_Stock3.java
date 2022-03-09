package com.algorithms.dynamicprogramming;

public class Leet123_Stock3 {
    public int maxProfit(int[] prices) {
        if (prices.length == 1 || prices.length == 0) return 0;
        int[][][] dp = new int[prices.length][3][2];

        dp[0][0][0] = 0;
        dp[0][1][0] = 0;
        dp[0][2][0] = 0;
        dp[0][0][1] = -1000000000;
        dp[0][1][1] = 0 - prices[0]; //Impossible to buy after 2 times
        dp[0][2][1] = -1000000000; //Impossible to buy before start

        for (int i = 1; i < prices.length; i++) {
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);

            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]);
        }
        return Math.max(dp[prices.length - 1][0][0],
                Math.max(dp[prices.length - 1][1][0], dp[prices.length - 1][2][0]));
    }


    //middle column is 0-1, the number of holding stock, it cannot be 2, you need to sell the stock then buy the second one
    //#未持股，卖出过1次，可能是今天卖的，可能是之前卖的
//    dp[i][0][1]=max(dp[i-1][1][0]+prices[i],dp[i-1][0][1])
//            #未持股，卖出过2次，可能是今天卖的，可能是之前卖的
//    dp[i][0][2]=max(dp[i-1][1][1]+prices[i],dp[i-1][0][2])
//            #持股，未卖出过，可能是今天买的，可能是之前买的
//    dp[i][1][0]=max(dp[i-1][0][0]-prices[i],dp[i-1][1][0])
//            #持股，卖出过1次，可能是今天买的，可能是之前买的
//    dp[i][1][1]=max(dp[i-1][0][1]-prices[i],dp[i-1][1][1])
//
//    链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/tong-su-yi-dong-de-dong-tai-gui-hua-jie-fa-by-marc/


    public int maxProfit1(int[] prices) {
        int dp[][][] = new int[prices.length][2][3];
        dp[0][0][0] = 0;
        dp[0][0][1] = -100001;
        dp[0][0][2] = -100001;
        dp[0][1][0] = -prices[0];
        dp[0][1][1] = -100001;
        dp[0][1][2] = -100001;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][1][0] + prices[i]);
            dp[i][0][2] = Math.max(dp[i - 1][0][2], dp[i - 1][1][1] + prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][0] - prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][1] - prices[i]);
        }
        return Math.max(dp[prices.length - 1][0][2], Math.max(dp[prices.length - 1][0][1], 0));
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
