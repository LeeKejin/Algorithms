package com.google.tree.dfs;

public class LongestIncreasingPathInMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = dfs(matrix, i, j, cache, -1);
                res = Math.max(res, count);
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] cache, int prev) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= prev) {
            return 0;
        }
        if (cache[i][j] != 0) return cache[i][j];
        int up = dfs(matrix, i - 1, j, cache, matrix[i][j]);
        int down = dfs(matrix, i + 1, j, cache, matrix[i][j]);
        int left = dfs(matrix, i, j - 1, cache, matrix[i][j]);
        int right = dfs(matrix, i, j + 1, cache, matrix[i][j]);
        int max = Math.max(Math.max(up, down), Math.max(left, right)) + 1;
        cache[i][j] = max;
        return max;
    }
}
