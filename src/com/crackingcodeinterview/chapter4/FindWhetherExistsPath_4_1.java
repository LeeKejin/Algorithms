package com.crackingcodeinterview.chapter4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FindWhetherExistsPath_4_1 {

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] point : graph) {
            map.putIfAbsent(point[0], new ArrayList<>());
            map.putIfAbsent(point[1], new ArrayList<>());
            map.get(point[0]).add(point[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        Set<Integer> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            int p = queue.poll();
            if (visited.contains(p)) continue;
            visited.add(p);
            List<Integer> list = map.get(p);
            if (list.contains(target)) return true;
            queue.addAll(list);
        }
        return false;
    }
}
