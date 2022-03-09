package com.amazon.interview.dp.prefix;

public class Leet926 {
    public int minFlipsMonoIncr(String s) {
        int zero = 0;
        int one = 0;
        //dp[i][0] all elements before i are 0, i is 0
        //dp[i][1] last element i=1, element before i could be 0 or 1, take the min one
        for (int i = 0; i < s.length(); i++) {
            int temp1 = zero + (s.charAt(i) == '0' ? 0 : 1);
            int temp2 = Math.min(zero, one) + (s.charAt(i) == '1' ? 0 : 1);
            zero = temp1;
            one = temp2;
        }
        return Math.min(zero, one);
    }

    public int minFlipsMonoIncr1(String s) {
        int left[] = new int[s.length() + 1];
        int right[] = new int[s.length() + 1];
        left[0] = s.charAt(0) == '0' ? 0 : 1;
        right[s.length() - 1] = s.charAt(s.length() - 1) == '1' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            left[i] = left[i - 1] + (s.charAt(i) == '0' ? 0 : 1);
        }
        for (int i = s.length() - 2; i >= 0; i--) {
            right[i] = right[i + 1] + (s.charAt(i) == '1' ? 0 : 1);
        }
        int res = right[0];
        for (int i = 0; i < s.length(); i++) {
            res = Math.min(res, left[i] + right[i + 1]);
        }
        return res;
    }

    public int minFlipsMonoIncrdp(String s) {
        int dp[][] = new int[s.length() + 1][2];
        //dp[i][0] all elements before i are 0, i is 0
        //dp[i][1] last element i=1, element before i could be 0 or 1, take the min one
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) == '0') {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + 1;
            } else {
                dp[i][0] = dp[i - 1][0] + 1;  //element before i must be 0
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]);//elements before i could be all 0 or all 1, take the min
            }
        }
        return Math.min(dp[s.length()][0], dp[s.length()][1]);
    }
}
