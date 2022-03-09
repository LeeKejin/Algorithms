package com.google.calander;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendar {
    Map<Integer, Integer> map = new TreeMap<>();

    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int active = 0;
        for (int event : map.values()) {
            active += event;
            if (active >= 2) {
                map.put(start, map.get(start) - 1);
                map.put(end, map.get(end) + 1);
                return false;
            }
        }
        return true;
    }
}
