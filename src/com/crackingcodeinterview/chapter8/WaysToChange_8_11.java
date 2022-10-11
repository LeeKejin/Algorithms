package com.crackingcodeinterview.chapter8;

public class WaysToChange_8_11 {
    public int waysToChange(int n) {
        int arr[] = new int[]{1, 5, 10, 25};
        int dp[] = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i]; j <= n; j++) {
                dp[j] = (dp[j] + dp[j - arr[i]]) % 1000000007;
            }
        }
        return dp[n];
    }
}
