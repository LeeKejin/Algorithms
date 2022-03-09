package com.amazon.interview.dp;

public class Leet91 {
    //see 11106->2  because 106 only has 1 combo
    //https://www.youtube.com/watch?v=OjEHST4SXfE
    public int numDecodings(String s) {
        if (s.length() == 1) {
            return s.charAt(0) == '0' ? 0 : 1;
        }
        int dp[] = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            int n1 = Integer.parseInt(String.valueOf(s.charAt(i - 1)));
            if (n1 >= 1 && n1 <= 9) {
                dp[i] += dp[i - 1];
            }
            if (i < 2) continue;
            String sub = s.substring(i - 2, i);
            if (sub.startsWith("0")) continue;
            int n2 = Integer.parseInt(sub);
            if (n2 >= 10 && n2 <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}
