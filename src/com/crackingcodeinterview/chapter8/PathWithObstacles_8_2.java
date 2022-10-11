package com.crackingcodeinterview.chapter8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathWithObstacles_8_2 {
    List<List<Integer>> res = new ArrayList<>();
    List<List<Integer>> temp = new ArrayList<>();

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return new ArrayList<>();
        dfs(obstacleGrid, 0, 0, m, n, new boolean[m][n]);
        return res;
    }

    private void dfs(int[][] obstacleGrid, int i, int j, int m, int n, boolean[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || obstacleGrid[i][j] == 1) return;
        if (i == m - 1 && j == n - 1) {
            visited[i][j] = true;
            temp.add(new ArrayList<>(Arrays.asList(i, j)));
            res.addAll(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
            visited[i][j] = false;
            return;
        }
        visited[i][j] = true;
        temp.add(new ArrayList<>(Arrays.asList(i, j)));

        dfs(obstacleGrid, i + 1, j, m, n, visited);
        dfs(obstacleGrid, i, j + 1, m, n, visited);
        temp.remove(temp.size() - 1);
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        PathWithObstacles_8_2 test = new PathWithObstacles_8_2();
        test.pathWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
    }
}
