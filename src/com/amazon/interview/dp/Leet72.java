package com.amazon.interview.dp;

public class Leet72 {

    //dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作
    //https://leetcode.com/problems/delete-operation-for-two-strings/ -> Leet 583
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
        int n = word1.length() + 1;
        int m = word2.length() + 1;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < m; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }

            }
        }
        return dp[n - 1][m - 1];
    }
}
