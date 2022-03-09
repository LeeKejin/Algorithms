package com.algorithms.dynamicprogramming.knapsack.complete;

public class Leet518 {
    //choose none of the coins would also be an option, then dp[0]=1;
    //https://leetcode-cn.com/problems/coin-change-2/solution/bei-bao-si-xiang-jie-jue-ling-qian-dui-huan-wen-ti/
    //https://programmercarl.com/0518.%E9%9B%B6%E9%92%B1%E5%85%91%E6%8D%A2II.html#_518-%E9%9B%B6%E9%92%B1%E5%85%91%E6%8D%A2-ii
      /*
    如果求组合数就是外层for循环遍历物品，内层for遍历背包。
    如果求排列数就是外层for遍历背包，内层for循环遍历物品。
    we need 组合 this time
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = dp[j - coins[i]];
            }
        }
        return dp[amount];
    }


}
