package com.amazon.interview.dfs;

import java.util.HashSet;
import java.util.Set;

public class Leet694 {
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(i, j, i, j, grid, sb);
                    set.add(sb.toString());
                }

            }
        }
        return set.size();
    }

    /*
     sb.append(i - prevX);  cannot be changed to  sb.append(Math.abs(i - prevX));
     because of the case
     [0,0,0,1,0],
     [0,1,0,1,1],
     [1,1,0,1,0],
     [0,1,0,0,0]
     */
    private void dfs(int i, int j, int prevX, int prevY, int[][] grid, StringBuilder sb) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) return;

        grid[i][j] = -1;
        sb.append(i - prevX);
        sb.append(j - prevY);
        dfs(i - 1, j, prevX, prevY, grid, sb);
        dfs(i + 1, j, prevX, prevY, grid, sb);
        dfs(i, j - 1, prevX, prevY, grid, sb);
        dfs(i, j + 1, prevX, prevY, grid, sb);
    }
}
