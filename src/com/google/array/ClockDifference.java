package com.google.array;

import java.util.List;

public class ClockDifference {
    public int findMinDifference(List<String> timePoints) {
        boolean mark[] = new boolean[60 * 24];
        for (String time : timePoints) {
            String[] arr = time.split(":");
            int h = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);
            int total = h * 60 + m;
            if (mark[total]) return 0;
            mark[total] = true;
        }
        int prev = 0;
        int first = Integer.MAX_VALUE;
        int last = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 24 * 60; i++) {
            if (mark[i]) {
                if (first != Integer.MAX_VALUE) {
                    min = Math.min(min, i - prev);
                }
                first = Math.min(first, i);
                last = Math.max(last, i);
                prev = i;
            }

        }
        min = Math.min(min, 24 * 60 - (last - first));
        return min;
    }
}
