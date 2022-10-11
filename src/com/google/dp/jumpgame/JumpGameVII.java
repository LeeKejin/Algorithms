package com.google.dp.jumpgame;

public class JumpGameVII {
    public boolean canReach(String s, int minJump, int maxJump) {
        if (s.length() == 0) return true;
        boolean dp[] = new boolean[s.length()];
        dp[0] = s.charAt(0) == '0';

        for (int i = 0, j = 0; i < s.length(); i++) {
            if (dp[i]) {
                for (j = Math.max(j, i + minJump); j <= Math.min(i + maxJump, s.length() - 1); j++) {
                    dp[j] = s.charAt(j) == '0';
                    if (dp[j]) {
                        if (j == s.length() - 1) return true;
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }
}
