package com.amazon.interview;

public class Leet161 {
    public boolean isOneEditDistance(String s, String t) {
        if (s.equals(t)) return false;
        if (s.length() < t.length()) {
            String temp = s;
            s = t;
            t = temp;
        }
        if (s.length() - t.length() > 1) return false;
        if (s.length() == t.length()) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) count++;
                if (count > 1) return false;
            }
            return true;
        }

        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (i - j > 1) return false;
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return i - j <= 1;
    }

    public boolean isOneEditDistanceDPSLOW(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n] == 1;
    }
}
