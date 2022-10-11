package com.google.graph;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslandsII {
    class UnionClass {
        int[] parent;

        public UnionClass(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        void merge(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }

        private int find(int x) {
            if (parent[x] != x) return find(parent[x]);
            return parent[x];
        }
    }

    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] matrix = new int[m][n];
        UnionClass unionClass = new UnionClass(m * n);
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < positions.length; i++) {
            int x = positions[i][0];
            int y = positions[i][1];
            matrix[x][y] = 1;
            boolean isMerged = false;
            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (inArea(newX, newY, m, n) && matrix[newX][newY] == 1) {
                    isMerged = true;
                    unionClass.merge(getIndex(newX, newY, n), getIndex(x, y, n));
                }
            }
            if (!isMerged) {
                if (list.isEmpty()) {
                    list.add(1);
                } else {
                    int v = list.get(list.size() - 1) + 1;
                    list.add(v);
                }
            } else {
                int c = 0;
                for (int k = 0; k < unionClass.parent.length; k++) {
                    if (unionClass.parent[k] == k) {
                        c++;
                    }
                }
                list.add(m * n - c);
            }
        }
        return list;
    }

    private boolean inArea(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    int getIndex(int x, int y, int n) {
        return x * n + y;
    }
}
