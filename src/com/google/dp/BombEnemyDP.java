package com.google.dp;

public class BombEnemyDP {
    public int maxKilledEnemies(char[][] grid) {
        int row = 0;
        int col[] = new int[grid[0].length];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (j == 0 || grid[i][j] == 'W') {
                    int c = grid[i][j] == 'W' ? j + 1 : j;
                    row = calRow(i, c, grid);
                }
                if (i == 0 || grid[i][j] == 'W') {
                    int r = grid[i][j] == 'W' ? i + 1 : i;
                    col[j] = calCol(r, j, grid);
                }
                if (grid[i][j] == '0') {
                    res = Math.max(res, col[j] + row);
                }
            }
        }
        return res;
    }

    private int calRow(int i, int j, char[][] grid) {
        int count = 0;
        while (j < grid[0].length && grid[i][j] != 'W') {
            if (grid[i][j] == 'E') count++;
            j++;
        }
        return count;
    }

    private int calCol(int i, int j, char[][] grid) {
        int count = 0;
        while (i < grid.length && grid[i][j] != 'W') {
            if (grid[i][j] == 'E') count++;
            i++;
        }
        return count;
    }


}
