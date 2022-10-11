package com.amazon.interview.dp.prefix;

public class FlipStringToMonotoneIncreasing {
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

    /**
     * 定义dp[i][0], dp[i][0]表示前i个元素递增且第i个元素为0的最小翻转次数，
     * 定义dp[i][1]， dp[i][1]表示前i个元素递增且第i个元素为1的最小翻转次数。
     * 由定义可知，如果前i个元素最后以0结尾且满足单调递增，那么前i个元素必须全部为0，由此可得dp[i][0]的状态转移如下：
     * dp[i][0] = dp[i-1][0] + (s.charAt(i)=='0'?0:1);
     * 由定义可知， dp[i][1]只要满足最后一个元素为1就行，那么前i-1个元素既可以为0，也可以为1，因此dp[i][1]的状态转移如下：
     * dp[i][1] = min(dp[i-1][1], dp[i-1][0]) + (s.charAt(i)=='1'?0:1)；
     *
     * @param s
     * @return
     */
    public int minFlipsMonoIncr2(String s) {
        int dp[][] = new int[s.length() + 1][2];

        for (int i = 1; i <= s.length(); i++) {
            dp[i][0] = dp[i - 1][0] + (s.charAt(i - 1) == '0' ? 0 : 1);
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (s.charAt(i - 1) == '1' ? 0 : 1);

        }
        return Math.min(dp[s.length()][0], dp[s.length()][1]);
    }
}
