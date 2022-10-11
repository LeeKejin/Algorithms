package com.google.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class DescribePainting {
    public List<List<Long>> splitPainting(int[][] segments) {
        TreeMap<Integer, Long> map = new TreeMap<>();
        for (int[] segment : segments) {
            map.put(segment[0], map.getOrDefault(segment[0], 0L) + segment[2]);
            map.put(segment[1], map.getOrDefault(segment[1], 0L) - segment[2]);
        }
        long sum = 0;
        long i = 0;
        List<List<Long>> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (sum > 0) {
                list.add(Arrays.asList(i, (long) key, sum));
            }
            sum += map.get(key);
            i = key;
        }
        return list;
    }
}
