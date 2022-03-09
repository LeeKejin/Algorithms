package com.google.tree;

public class Leet947 {
    class UnionClass {
        int parents[];

        public UnionClass(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        public void merge(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parents[rootX] = rootY;
            }
        }

        private int find(int x) {
            if (x != parents[x]) return find(parents[x]);
            return parents[x];
        }

        boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }

    UnionClass unionClass;

    public int removeStones(int[][] stones) {
        int n = stones.length;
        unionClass = new UnionClass(n);
        for (int i = 0; i < stones.length; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    if (!unionClass.isConnected(i, j)) {
                        unionClass.merge(i, j);
                    }
                }
            }
        }


        int count = 0;
        for (int i = 0; i < unionClass.parents.length; i++) {
            if (unionClass.parents[i] == i) count++;
        }
        return n - count;
    }
}
