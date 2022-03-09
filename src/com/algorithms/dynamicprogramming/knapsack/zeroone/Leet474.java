package com.algorithms.dynamicprogramming.knapsack.zeroone;

public class Leet474 {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs.length == 0) return 0;

        int[][][] dp = new int[strs.length][m + 1][n + 1];
        int[] cont = counter(strs[0]);

        //Initialize
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i - cont[0] >= 0 && j - cont[1] >= 0) dp[0][i][j] = 1;
            }
        }

        for (int i = 1; i < strs.length; i++) {
            int[] contInner = counter(strs[i]);
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= contInner[0] && k >= contInner[1]) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k],
                                dp[i - 1][j - contInner[0]][k - contInner[1]] + 1);
                    }

                }
            }
        }
        return dp[strs.length - 1][m][n];
    }

    public int findMaxFormDP(String[] strs, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        int count[] = counter(strs[0]);
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i - count[0] >= 0 && j - count[1] >= 0) dp[i][j] = 1;
            }
        }

        for (int i = 1; i < strs.length; i++) {
            int pair[] = counter(strs[i]);
            for (int j = m; j >= 0; j--) {
                for (int k = n; k >= 0; k--) {
                    if (j - pair[0] >= 0 && k - pair[1] >= 0)
                        dp[j][k] = Math.max(dp[j][k], dp[j - pair[0]][k - pair[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int[] counter(String str) {
        int zero = 0;
        int one = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '0') zero++;
            if (ch == '1') one++;
        }
        return new int[]{zero, one};
    }
}
