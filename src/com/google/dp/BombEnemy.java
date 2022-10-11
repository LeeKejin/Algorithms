package com.google.dp;

public class BombEnemy {
    public int maxKilledEnemies(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') {
                    int count = cal(grid, i, j);
                    res = Math.max(res, count);
                }
            }
        }
        return res;
    }

    private int cal(char[][] grid, int i, int j) {
        int count = 0;
        int r = i;
        while (r >= 0 && grid[r][j] != 'W') {
            if (grid[r][j] == 'E') {
                count++;
            }
            r--;
        }
        r = i;
        while (r < grid.length && grid[r][j] != 'W') {
            if (grid[r][j] == 'E') {
                count++;
            }
            r++;
        }
        int c = j;
        while (c < grid[0].length && grid[i][c] != 'W') {
            if (grid[i][c] == 'E') {
                count++;
            }
            c++;
        }
        c = j;
        while (c >= 0 && grid[i][c] != 'W') {
            if (grid[i][c] == 'E') {
                count++;
            }
            c--;
        }
        return count;
    }
}
