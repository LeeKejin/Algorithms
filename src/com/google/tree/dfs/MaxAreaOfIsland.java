package com.google.tree.dfs;

public class MaxAreaOfIsland {
    int area = 0;
    int count = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count = 0;
                    dfs(grid, i, j, visited);
                    area = Math.max(area, count);
                }
            }
        }
        return area;
    }

    private void dfs(int[][] grid, int i, int j, boolean visited[][]) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] != 1) return;

        count++;
        visited[i][j] = true;
        dfs(grid, i - 1, j, visited);
        dfs(grid, i + 1, j, visited);
        dfs(grid, i, j - 1, visited);
        dfs(grid, i, j + 1, visited);
    }
}
