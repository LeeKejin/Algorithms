package com.google.tree.dfs.longestconsecutive;

import java.util.*;

public class TreeDiameter {
    int max = 0;

    public int treeDiameter(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());

            map.get(edge[0]).add(edge[1]);
//            map.get(edge[1]).add(edge[0]);  //the Set and this step can be removed, there won't be duplicated element in a directional graph
        }
        Set<Integer> set = new HashSet<>();
        dfs(0, set, map);
        return max;
    }

    private int dfs(int start, Set<Integer> set, Map<Integer, List<Integer>> map) {
        set.add(start);
        int d1 = 0;
        int d2 = 0;
        for (int next : map.getOrDefault(start, new ArrayList<>())) {
            if (set.contains(next)) continue;
            int d = 0;
            d += dfs(next, set, map) + 1;
            if (d > d1) {
                d2 = d1;
                d1 = d;
            } else if (d > d2) {
                d2 = d;
            }
        }
        max = Math.max(max, d2 + d1);
        return Math.max(d2, d1);
    }
}
