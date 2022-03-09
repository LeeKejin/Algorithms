package com.google.dp;

public class StudentAttendanceRecordII {
    int mod = 1000000007;

    int[][][] memo;

    public int checkRecord(int n) {
        memo = new int[n][2][3];
        return dfs(n, 0, 0, 0);
    }

    private int dfs(int n, int d, int absent, int late) {
        if (n == d) return 1;
        if (memo[d][absent][late] != 0) return memo[d][absent][late];
        int res = 0;
        res = (res + dfs(n, d + 1, absent, 0)) % mod;
        if (absent < 1) {
            res = (res + dfs(n, d + 1, absent + 1, 0)) % mod;
        }
        if (late < 2) {
            res = (res + dfs(n, d + 1, absent, late + 1)) % mod;
        }
        memo[d][absent][late] = res;
        return res;
    }


    //https://leetcode-cn.com/problems/student-attendance-record-ii/solution/tong-ge-lai-shua-ti-la-yi-ti-liu-jie-dfs-s5fa/
    public int checkRecordDP(int n) {
        long[][][] dp = new long[n][2][3];
        dp[0][0][0] = 1;
        dp[0][1][0] = 1;
        dp[0][0][1] = 1;

        for (int i = 1; i < n; i++) {
            dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % mod;
            dp[i][1][0] = (dp[i - 1][1][0] + dp[i - 1][1][1] + dp[i - 1][1][2]) % mod;
            // 本次填入A，前一天没有累计A都能转移过来
            // 这行可以与上面一行合并计算，为了方便理解，我们分开，下面会合并
            dp[i][1][0] = (dp[i][1][0] + dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % mod;

            dp[i][0][1] = dp[i - 1][0][0];
            dp[i][0][2] = dp[i - 1][0][1];
            dp[i][1][1] = dp[i - 1][1][0];
            dp[i][1][2] = dp[i - 1][1][1];

        }
        long ans = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                ans = (ans + dp[n - 1][i][j]) % mod;
            }
        }


        return (int) ans;
    }

    public static void main(String[] args) {
        StudentAttendanceRecordII test = new StudentAttendanceRecordII();
        test.checkRecordDP(4);
    }
}
