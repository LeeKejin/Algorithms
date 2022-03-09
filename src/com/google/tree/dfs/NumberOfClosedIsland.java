package com.google.tree.dfs;

public class NumberOfClosedIsland {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(i, 0, grid, visited);
            dfs(i, n - 1, grid, visited);
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j, grid, visited);
            dfs(m - 1, j, grid, visited);
        }
        int count = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    dfs(i, j, grid, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, int[][] grid, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] != 0) {
            return;
        }

        visited[i][j] = true;
        dfs(i - 1, j, grid, visited);
        dfs(i + 1, j, grid, visited);
        dfs(i, j - 1, grid, visited);
        dfs(i, j + 1, grid, visited);
    }
}
