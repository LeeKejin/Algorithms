package com.algorithms.dynamicprogramming.knapsack.zeroone;

import java.util.Arrays;

public class Leet1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int target = sum / 2;
        int dp[] = new int[target];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; i >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[target] * 2;
    }
}
