package com.google.dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
O(MN)
 */
public class MakingALargeIsland {
    int count = 0;

    public int largestIsland(int[][] grid) {
        int color = 2;
        int m = grid.length;
        int n = grid[0].length;
        Map<Integer, Integer> areaMap = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, grid, color);
                    areaMap.put(color, count);
                    color++;
                    count = 0;
                }
            }
        }
        if (areaMap.isEmpty()) return 1;
        int area = areaMap.get(2);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    if (i - 1 >= 0) {
                        set.add(grid[i - 1][j]);
                    }
                    if (i + 1 < m) {
                        set.add(grid[i + 1][j]);
                    }
                    if (j - 1 >= 0) {
                        set.add(grid[i][j - 1]);
                    }
                    if (j + 1 < n) {
                        set.add(grid[i][j + 1]);
                    }
                    int size = 1;
                    for (int c : set) {
                        size += areaMap.getOrDefault(c, 0);
                    }
                    area = Math.max(area, size);
                }
            }
        }
        return area;
    }

    private void dfs(int i, int j, int[][] grid, int color) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) return;
        grid[i][j] = color;
        count++;
        dfs(i - 1, j, grid, color);
        dfs(i + 1, j, grid, color);
        dfs(i, j - 1, grid, color);
        dfs(i, j + 1, grid, color);
    }
}
