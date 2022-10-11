package com.amazon.interview.topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
//https://leetcode.com/problems/course-schedule-ii/
public class Leet210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] degrees = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        for (int[] pre : prerequisites) {
            map.putIfAbsent(pre[1], new ArrayList<>());
            map.get(pre[1]).add(pre[0]);
            degrees[pre[0]]++;
        }
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] == 0) queue.add(i);
        }
        int res[] = new int[numCourses];
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int c = queue.poll();
            list.add(c);

            for (int later : map.get(c)) {
                degrees[later]--;
                if (degrees[later] == 0) {
                    queue.add(later);
                }
            }
        }
        if (list.size() < numCourses) return new int[]{};
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
