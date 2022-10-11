package com.google.dp;

public class BurstBalloons {
    public int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;


        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k)
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i)
                    dp[left][right] = Math.max(dp[left][right],
                            nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
            }

        return dp[0][n - 1];
    }

    public int maxCoinsMemo(int[] nums) {
        int n = nums.length;
        int[] copy = new int[n + 2];
        copy[0] = 1;
        copy[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            copy[i] = nums[i - 1];
        }
        int[][] memo = new int[n + 2][n + 2];
        return dfs(copy, memo, 0, n + 1);
    }

    private int dfs(int[] copy, int[][] memo, int left, int right) {
        if (left + 1 == right) return 0;
        if (memo[left][right] > 0) return memo[left][right];

        for (int i = left + 1; i < right; i++) {
            memo[left][right] = Math.max(memo[left][right],
                    dfs(copy, memo, left, i) + copy[left] * copy[i] * copy[right] + dfs(copy, memo, i, right));

        }
        return memo[left][right];
    }

}
