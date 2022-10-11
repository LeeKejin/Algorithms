package com.google.dp;

import java.util.Arrays;

public class MaximumVacationDays {
    int memo[][];

    public int maxVacationDays(int[][] flights, int[][] days) {
        memo = new int[flights.length][days[0].length];
        for (int i = 0; i < flights.length; i++) {
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }

        return dfs(flights, days, 0, 0);
    }

    private int dfs(int[][] flights, int[][] days, int cur_city, int weekno) {
        if (weekno == days[0].length)
            return 0;
        if (memo[cur_city][weekno] != Integer.MIN_VALUE)
            return memo[cur_city][weekno];
        for (int i = 0; i < flights.length; i++) {
            if (flights[cur_city][i] == 1 || i == cur_city) {
                int vac = days[i][weekno] + dfs(flights, days, i, weekno + 1);
                memo[cur_city][weekno] = Math.max(memo[cur_city][weekno], vac);
            }
        }
        return memo[cur_city][weekno];
    }
}
