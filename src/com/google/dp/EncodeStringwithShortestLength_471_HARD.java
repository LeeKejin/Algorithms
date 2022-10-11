package com.google.dp;

public class EncodeStringwithShortestLength_471_HARD {
    public String encode(String s) {
        if (s.length() < 5) return s;
        String[][] dp = new String[s.length()][s.length()];
        for (int len = 1; len <= s.length(); len++) {
            for (int start = 0; start + len <= s.length(); start++) {
                int end = start + len - 1;
                String shortest = s.substring(start, end + 1);
                if (len < 5) {
                    dp[start][end] = shortest;
                    continue;
                }

                int repeatPos = (shortest + shortest).indexOf(shortest, 1);
                if (repeatPos < shortest.length()) {
                    shortest = Integer.toString(shortest.length() / repeatPos) + "[" + dp[start][start + repeatPos - 1] + "]";
                }
                for (int p = start; p < end; p++) {
                    if (dp[start][p].length() + dp[p + 1][end].length() < shortest.length()) {
                        shortest = dp[start][p] + dp[p + 1][end];
                    }
                }
                dp[start][end] = shortest;
            }
        }

        return dp[0][s.length() - 1];
    }
}
