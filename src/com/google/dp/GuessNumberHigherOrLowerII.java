package com.google.dp;

public class GuessNumberHigherOrLowerII {
    int[][] dp;

    //https://leetcode.com/problems/guess-number-higher-or-lower-ii/discuss/84787/Java-DP-solution
    //Definition of dp[i][j]: minimum number of money to guarantee win for subproblem [i, j].
    public int getMoneyAmount(int n) {
        dp = new int[n + 1][n + 1];
        return dfs(1, n);
    }

    private int dfs(int l, int r) {
        if (l >= r) return 0;
        if (dp[l][r] != 0) return dp[l][r];
        int res = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            int tmp = i + Math.max(dfs(l, i - 1), dfs(i + 1, r));
            res = Math.min(res, tmp);
        }
        dp[l][r] = res;
        return dp[l][r];
    }
}
