package com.google.interval;

import java.util.TreeMap;

public class DataStreamAsDisjointIntervals {
    private TreeMap<Integer, Integer> map = new TreeMap<>();

    public void addNum(int val) {
        if (map.containsKey(val)) return;
        Integer left = map.floorKey(val);
        Integer right = map.ceilingKey(val);
        if (left != null && right != null && map.get(left) + 1 == val && right - 1 == val) {
            int end = map.remove(right);
            map.put(left, end);
        } else if (left != null && map.get(left) + 1 >= val) { //This >= is important
            map.put(left, Math.max(val, map.get(left)));
        } else if (right != null && right - 1 == val) {
            int end = map.remove(right);
            map.put(val, end);
        } else {
            map.put(val, val);
        }

    }

    public int[][] getIntervals() {
        int i = 0;
        int[][] res = new int[map.size()][2];
        for (Integer key : map.keySet()) {
            res[i][0] = key;
            res[i][1] = map.get(key);
            i++;
        }
        return res;
    }
}
