package com.amazon.interview.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfProvinces {
    /*
    Province dfs (O(N^2))
     */
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < isConnected.length; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (i == j) continue;
                if (isConnected[i][j] == 1) list.get(i).add(j);
            }
        }

        boolean[] visited = new boolean[isConnected.length];

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, list, visited);
            }
        }
        return count;
    }

    private void dfs(int i, List<List<Integer>> list, boolean[] visited) {
        if (visited[i]) return;
        visited[i] = true;
        for (int c : list.get(i)) {
            dfs(c, list, visited);
        }
    }

    //DisJoint
    class UnionClass {
        Map<Integer, Integer> map = new HashMap<>();

        int setNumber;

        public void add(int value) {
            if (!map.containsKey(value)) {
                map.put(value, null);
                setNumber++;
            }
        }

        public void merge(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                map.put(rootI, rootJ);
                setNumber--;
            }
        }

        private int find(int value) {
            int root = value;
            while (map.get(root) != null) {
                root = map.get(root);
            }
            while (root != value) {
                int origin = map.get(value);

                map.put(value, root);
                value = origin;

            }
            return root;
        }
    }

    private int findCircleNum1(int[][] isConnected) {
        UnionClass unionClass = new UnionClass();
        for (int i = 0; i < isConnected.length; i++) {
            unionClass.add(i);
            for (int j = 0; j < i; j++) {
                if (isConnected[i][j] == 1) {
                    unionClass.merge(i, j);
                }
            }
        }
        return unionClass.setNumber;
    }

    public int findCircleNumDFS(int[][] isConnected) {
        int m = isConnected.length;
        int count = 0;
        boolean[] visited = new boolean[m];
        for (int i = 0; i < m; i++) {
            if (!visited[i]) {
                dfs(isConnected, i, visited);
                count++;
            }
        }

        return count;
    }

    private void dfs(int[][] isConnected, int i, boolean[] visited) {
        if (visited[i]) return;
        visited[i] = true;
        int[] cities = isConnected[i];
        for (int j = 0; j < cities.length; j++) {
            if (j == i) continue;
            if (cities[j] == 1) dfs(isConnected, j, visited);
        }
    }

}
