package com.algorithms.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class Leet120 {

    public int minimumTotalRec(List<List<Integer>> triangle) {
        return calculate(triangle, 0, 0);
    }

    private int calculate(List<List<Integer>> triangle, int row, int column) {
        if (row == triangle.size()) return 0;
        return triangle.get(row).get(column) +
                Math.min(calculate(triangle, row + 1, column), calculate(triangle, row + 1, column + 1));
    }

    //have to calculate from bottom to top!
    public static int minimumTotal(int[][] triangle) {
        int n = triangle.length;
        int dp[][] = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j];
            }
        }
        return dp[0][0];
    }

    //optimize space
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> results = new ArrayList<>();
        int size = triangle.size() - 1;
        results.addAll(triangle.get(size));
        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int val = Math.min(results.get(j), results.get(j + 1)) + triangle.get(i).get(j);
                results.set(j, val);
            }
        }
        return results.get(0);
    }

    public int minimumTotalTopToBotton(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[][] dp = new int[m][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j];
                } else if (j == triangle.get(i).size() - 1) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            sum = Math.min(sum, dp[m - 1][i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        int grid[][] = new int[][]{{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        System.out.print(minimumTotal(grid));
    }
}
