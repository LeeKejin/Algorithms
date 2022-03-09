package com.amazon.interview.graph;

public class Leet765 {
    private class UnionClass {
        private int[] parent;
        private int count;

        public UnionClass(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            count = n;
        }

        public int getCount() {
            return count;
        }

        private int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }


        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
                count--;
            }
        }
    }

    public int minSwapsCouples(int[] row) {
        int len = row.length;
        int N = len / 2;
        UnionClass unionFind = new UnionClass(N);
        for (int i = 0; i < len; i += 2) {
            unionFind.union(row[i] / 2, row[i + 1] / 2);
        }
        return N - unionFind.getCount();

    }
}
