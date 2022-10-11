package com.google.interval;

import java.util.TreeMap;

//https://leetcode.com/problems/range-module/
public class RangeModule_WTF {
    public RangeModule_WTF() {

    }

    private TreeMap<Integer, Integer> map = new TreeMap<>();

    public void addRange(int left, int right) {
        if (map.isEmpty()) {
            map.put(left, right);
            return;
        }
        Integer start = map.floorKey(left);
        if (start == null) start = map.ceilingKey(left);
        while (start != null && start <= right) {
            int end = map.get(start);
            if (end >= left) {
                map.remove(start);
                left = Math.min(left, start);
                right = Math.max(right, end);
            }
            start = map.ceilingKey(end);
        }
        map.put(left, right);
    }

    public boolean queryRange(int left, int right) {
        Integer start = map.floorKey(left);
        if (start != null && map.get(start) >= right) return true;
        return false;
    }

    public void removeRange(int left, int right) {
        if (map.isEmpty()) return;
        Integer start = map.floorKey(left);
        if (start == null) start = map.ceilingKey(left);
        while (start != null && start < right) {
            int end = map.get(start);
            if (end > left) {
                map.remove(start);
                if (start < left) map.put(start, left);
                if (end > right) map.put(right, end);
            }
            start = map.ceilingKey(end);
        }
    }
}

