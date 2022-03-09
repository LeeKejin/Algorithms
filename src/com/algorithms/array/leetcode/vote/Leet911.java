package com.algorithms.array.leetcode.vote;

import java.util.HashMap;
import java.util.Map;

public class Leet911 {
    int[][] map;

    public Leet911(int[] persons, int[] times) {
        int m = persons.length;
        map = new int[m][2];
        int val = 0;
        Map<Integer, Integer> vote = new HashMap<>();

        for (int i = 0; i < m; i++) {
            map[i][0] = times[i];
            vote.put(persons[i], vote.getOrDefault(persons[i], 0) + 1);
            if (vote.get(persons[i]) >= val) {
                val = vote.get(persons[i]);
                map[i][1] = persons[i];
            } else {
                map[i][1] = map[i - 1][1];
            }
        }
    }

    public int q(int t) {
        int index = find(0, map.length - 1, t);
        return map[index][1];
    }

    //小于t最大值
    private int find(int start, int end, int t) {
        if (start >= end) return start;
        int mid = start + (end - start + 1) / 2;
        if (map[mid][0] <= t) {
            return find(mid, end, t);
        }
        return find(start, mid - 1, t);
    }


}
