package com.algorithms.dynamicprogramming.amazon;
//https://leetcode.com/problems/paint-fence/
//paint fin
//paint fence
public class Leet276 {
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        if (n == 1) return k;

        int dp[] = new int[n + 1];
        dp[1] = k;
        dp[2] = k * k;
        for (int i = 3; i <= n; i++) {
            dp[i] = (k - 1) * (dp[i - 2] + dp[i - 1]);
        }
        return dp[n];
    }
}
