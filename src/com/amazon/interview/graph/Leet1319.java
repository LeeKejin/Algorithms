package com.amazon.interview.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet1319 {
    class UnionClass {
        int[] parents;

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
            if (x != parents[x]) {
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        UnionClass unionClass = new UnionClass(n);
        for (int[] connect : connections) {
            if (!unionClass.isConnected(connect[0], connect[1])) {
                unionClass.merge(connect[0], connect[1]);
            }
        }
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (unionClass.isConnected(i - 1, i)) continue;
            count++;
            unionClass.merge(i - 1, i);
        }
        return count;
    }

    Map<Integer, List<Integer>> map = new HashMap<>();
    int count = 0;

    public int makeConnectedDFS(int n, int[][] connections) {
        if (n - 1 > connections.length) return -1;
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] connection : connections) {
            map.get(connection[0]).add(connection[1]);
            map.get(connection[1]).add(connection[0]);
        }
        boolean visited[] = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited);
                count++;
            }
        }
        return count - 1;
    }

    private void dfs(int i, boolean[] visited) {
        if (visited[i]) return;
        visited[i] = true;
        for (int p : map.get(i)) {
            dfs(p, visited);
        }
    }

    public static void main(String[] args) {
        Leet1319 test = new Leet1319();
        test.makeConnectedDFS(4, new int[][]{{0, 1}, {0, 2}, {1, 2}});
    }
}
