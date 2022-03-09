package com.google.array;

import java.util.ArrayList;
import java.util.List;

public class Leet289 {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                check(list, board, i, j);
            }
        }
        for (int p[] : list) {
            if (board[p[0]][p[1]] == 1) {
                board[p[0]][p[1]] = 0;
            } else {
                board[p[0]][p[1]] = 1;
            }
        }
    }

    private void check(List<int[]> list, int[][] board, int i, int j) {
        int[][] dirs = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int count = 0;
        boolean isLive = board[i][j] == 1;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) continue;
            if (board[x][y] == 1) count++;
        }
        if (!isLive && count == 3) list.add(new int[]{i, j});
        if (isLive && count < 2) list.add(new int[]{i, j});
        if (isLive && count > 3) list.add(new int[]{i, j});
    }
}
