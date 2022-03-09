package com.google.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestPathInGridWithObstacles {
    class Status {
        int row;
        int col;
        int quote = 0;

        public Status(int row, int col, int quote) {
            this.row = row;
            this.col = col;
            this.quote = quote;
        }

        @Override
        public int hashCode() {
            // needed when we put objects into any container class
            return (this.row + 1) * (this.col + 1) * this.quote;
        }

        @Override
        public boolean equals(Object other) {
            /**
             * only (row, col, k) matters as the state info
             */
            if (!(other instanceof Status)) {
                return false;
            }
            Status newState = (Status) other;
            return (this.row == newState.row) && (this.col == newState.col) && (this.quote == newState.quote);
        }
    }

    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public int shortestPath(int[][] grid, int k) {
        Queue<Status> queue = new LinkedList<>();
        Status first = new Status(0, 0, k);

        queue.add(first);
        int m = grid.length;
        int n = grid[0].length;
//        boolean[][] visited = new boolean[m][n];
//        visited[0][0] = true;
        Set<Status> set = new HashSet<>();
        set.add(first);

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Status status = queue.poll();
                int row = status.row;
                int col = status.col;
                int quote = status.quote;
                if (row == m - 1 && col == n - 1) return step;

                for (int[] dir : dirs) {
                    int x = dir[0] + row;
                    int y = dir[1] + col;

                    if (x >= m || y >= n || x < 0 || y < 0) continue;
                    int nextElimination = quote - grid[x][y];
                    Status s = new Status(x, y, nextElimination);

                    if (!set.contains(s) && nextElimination >= 0) {
                        set.add(s);
                        queue.add(s);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public int shortestPathWithArray(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][][] visited = new boolean[m][n][k + 1];
        Queue<int[]> queue = new LinkedList<>();
        visited[0][0][k] = true;
        int step = 0;
        queue.add(new int[]{0, 0, k});

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                int row = point[0];
                int col = point[1];
                int quote = point[2];
                if (row == m - 1 && col == n - 1) return step;
                for (int[] dir : dirs) {
                    int x = dir[0] + row;
                    int y = dir[1] + col;

                    if (x < 0 || x >= m || y < 0 || y >= n) continue;
                    int q = quote - grid[x][y];
                    if (q >= 0 && !visited[x][y][q]) {
                        queue.add(new int[]{x, y, q});
                        visited[x][y][q] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
