package com.google.binary;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = binarySearch(intervals, newInterval[0], true);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < left; i++) {
            list.add(intervals[i]);
        }
        int right = binarySearch(intervals, newInterval[1], false);
        if (right == -1 || left == intervals.length) {
            list.add(newInterval);
        } else {
            list.add(new int[]{Math.min(intervals[left][0], newInterval[0]), Math.max(intervals[right][1], newInterval[1])});
        }
        for (int i = right + 1; i < intervals.length; i++) {
            list.add(intervals[i]);
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    int binarySearch(int[][] intervals, int target, boolean isLeft) {
        int l = 0;
        int r = intervals.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target >= intervals[mid][0] && target <= intervals[mid][1]) {
                return mid;
            }
            if (target < intervals[mid][0]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (isLeft) {
            return l;
        }
        return r;
    }
}
