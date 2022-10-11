package com.google.dp;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int m = p.length();
        int n = s.length();
        boolean dp[][] = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        //match empty s "" with p like a*b*c*
        for (int i = 1; i <= m; i++) {//dp[ i - 2 ][ 0 ] make *=0, check if previous 2 char is true, previous 1 char is deleted by *=0
            if (p.charAt(i - 1) == '*' && dp[i - 2][0]) {
                dp[i][0] = true;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(j - 1) == p.charAt(i - 1) || p.charAt(i - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(i - 1) == '*') {
                    if (p.charAt(i - 2) == s.charAt(j - 1) || p.charAt(i - 2) == '.') {
                        //* is the times of the appearance of the SAME character
                        //dp[ i - 1 ][ j ] ->match only previous character, ignore *, *=1
                        //dp[ i - 2 ][ j ] ->ignore * and it previous character, *=0, especially .* to delete . ----> s="asdf"  p=".*asdf.*"

                        //dp[ i ][ j - 1 ] -> *=more than one, match multiple characters
                        dp[i][j] = dp[i - 1][j] || dp[i - 2][j] || dp[i][j - 1];
                    } else {
                        //delete the previous character of *, *=0, * MUST follow a num, so dp[i-2][j] is must be an number rather than *
                        dp[i][j] = dp[i - 2][j];
                    }

                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        RegularExpressionMatching l = new RegularExpressionMatching();
//        l.isMatch("mississippi", "mis*is*p*.");
        l.isMatch("aab",
                "c*a*b");
    }
}
