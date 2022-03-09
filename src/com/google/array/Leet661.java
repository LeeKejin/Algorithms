package com.google.array;

public class Leet661 {
    public int[][] imageSmoother(int[][] M) {
        int m = M.length;
        int n = M[0].length;
        int[][] answer = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                answer[i][j] = cal(M, i, j);
            }
        }
        return answer;
    }

    private int cal(int[][] M, int i, int j) {
        int[][] dirs = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int sum = M[i][j];
        int count = 0;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= M.length || y < 0 || y >= M[0].length) {
                continue;
            }
            count++;
            sum += M[x][y];
        }
        return sum / (count + 1);
    }
}
