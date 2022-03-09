package com.google.calander;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MyCalendarTwo {
    /*
    O(N^2)
     */
    public MyCalendarTwo() {

    }

    List<int[]> calendars = new ArrayList<>();
    List<int[]> overlaps = new ArrayList<>();

    public boolean book(int start, int end) {
        for (int[] over : overlaps) {
            if ((start < over[1]) && (end > over[0])) {
                return false;
            }
        }
        for (int cal[] : calendars) {
            if ((start < cal[1]) && (end > cal[0])) {
                int[] a = new int[]{Math.max(start, cal[0]), Math.min(end, cal[1])};
                overlaps.add(a);
            }
        }
        calendars.add(new int[]{start, end});
        return true;
    }


    TreeMap<Integer, Integer> map = new TreeMap<>();

    public boolean bookWithoutDeletingMap(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int active = 0;
        for (int event : map.values()) {
            active += event;
            if (active >= 3) {
                map.put(start, map.get(start) - 1);
                map.put(end, map.get(end) + 1);
                return false;
            }
        }
        return true;
    }

    public boolean bookDeletingMap(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int active = 0;
        for (int event : map.values()) {
            active += event;
            if (active >= 3) {
                map.put(start, map.get(start) - 1);
                map.put(end, map.get(end) + 1);
                if (map.get(start) == 0) {
                    map.remove(start);
                }
                if (map.get(end) == 0) {
                    map.remove(end);
                }
                return false;
            }
        }
        return true;
    }
}
