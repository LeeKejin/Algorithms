package com.google.dp.knapsack.zeroone;

import java.util.Arrays;

public class Leet1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int dp[] = new int[sum / 2 + 1];

        for (int i = 0; i < stones.length; i++) {
            for (int j = dp.length - 1; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[dp.length - 1] * 2;
    }

}
