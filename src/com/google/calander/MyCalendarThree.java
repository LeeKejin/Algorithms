package com.google.calander;

import java.util.TreeMap;

/*
O(N^2)
 */
public class MyCalendarThree {
    TreeMap<Integer, Integer> map = new TreeMap<>();

    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int k = 0;
        int active = 0;
        for (int event : map.values()) {
            active += event;
            k = Math.max(k, active);
        }
        return k;
    }
}
