package com.google.bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//O(2^(n*m))
public class MinNumberOfFlipsConvertBinaryMatrixZeroMatrix {
    public int minFlips(int[][] mat) {
        Set<int[][]> visited = new HashSet<>();
        visited.add(mat);
        Queue<int[][]> queue = new LinkedList<>();
        queue.add(mat);
        visited.add(mat);
        int m = mat.length;
        int n = mat[0].length;
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[][] cur = queue.poll();
                if (check(cur)) return step;

                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        int[][] copy = flip(cur, i, j);
                        if (exists(copy, visited)) {
                            continue;
                        } else {
                            visited.add(copy);
                            queue.add(copy);
                        }
                    }
                }

            }
            step++;
        }
        return -1;
    }

    private boolean exists(int[][] mat, Set<int[][]> visited) {
        for (int[][] v : visited) {
            if (same(mat, v)) return true;
        }
        return false;
    }

    private boolean same(int[][] mat1, int[][] mat2) {
        int m = mat1.length;
        int n = mat1[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat1[i][j] != mat2[i][j]) return false;
            }
        }
        return true;
    }

    private int[][] flip(int[][] cur, int i, int j) {
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m = cur.length;
        int n = cur[0].length;
        int[][] copy = new int[m][n];

        for (int k = 0; k < m; k++) {
            copy[k] = Arrays.copyOf(cur[k], n);
        }
        copy[i][j] = cur[i][j] == 0 ? 1 : 0;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n) continue;
            copy[x][y] = cur[x][y] == 0 ? 1 : 0;
        }
        return copy;
    }

    private boolean check(int[][] cur) {
        for (int i = 0; i < cur.length; i++) {
            for (int j = 0; j < cur[0].length; j++) {
                if (cur[i][j] != 0) return false;
            }
        }
        return true;
    }
}
