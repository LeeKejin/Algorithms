package com.algorithms.dynamicprogramming.knapsack;

public class Leet518
{
    //choose none of the coins would also be an option, then dp[0]=1;
    //https://leetcode-cn.com/problems/coin-change-2/solution/bei-bao-si-xiang-jie-jue-ling-qian-dui-huan-wen-ti/
    public int change( int amount, int[] coins )
    {
        int[] dp = new int[ amount + 1 ];

        dp[ 0 ] = 1;
        for ( int i = 0; i < coins.length; i++ )
        {
            for ( int j = 1; j <= amount; j++ )
            {
                if ( j < coins[ i ] ) continue;

                dp[ j ] = dp[ j - coins[ i ] ] + dp[ j ];

            }
        }
        return dp[ amount ];
    }
}
