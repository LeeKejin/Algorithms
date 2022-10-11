package com.google.greedy;

import java.util.Arrays;

public class TwoCityScheduling {

    public int twoCitySchedCost(int[][] costs) {
        int dp[] = new int[costs.length];
        Arrays.sort(costs, (a, b) -> ((a[0] - a[1]) - (b[0] - b[1])));
        int res = 0;
        int n = costs.length / 2;
        for (int i = 0; i < costs.length / 2; i++) {
            res += (costs[i][0] + costs[i + n][1]);
        }
        return res;
    }

    
    int res = Integer.MAX_VALUE;

    public int twoCitySchedCostBF(int[][] costs) {
        int n = costs.length / 2;
        int a = n;
        int b = n;
        dfs(costs, a, b, 0, 0, 0);
        return res;
    }

    private void dfs(int[][] costs, int a, int b, int i, int costA, int costB) {
        if (i == costs.length && a == 0 && b == 0) {
            res = Math.min(res, costB + costA);
            return;
        }
        if (a > 0) {
            dfs(costs, a - 1, b, i + 1, costA + costs[i][0], costB);
        }
        if (b > 0) {
            dfs(costs, a, b - 1, i + 1, costA, costB + costs[i][1]);
        }
    }
}
