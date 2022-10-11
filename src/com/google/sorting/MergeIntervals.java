package com.google.sorting;

import java.util.*;

//https://leetcode.com/problems/merge-intervals/
//leet56
public class MergeIntervals {
    //you can use priorityQ tof sort, but the method does NOT need sort
    public int[][] merge(int[][] intervals) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            min = Math.min(min, interval[0]);
            max = Math.max(max, interval[1]);
        }
        int starts[] = new int[max + 1];
        int ends[] = new int[max + 1];
        for (int[] interval : intervals) {
            starts[interval[0]]++;
            ends[interval[1]]++;
        }
        List<int[]> list = new ArrayList<>();
        int start = min;
        int sCount = 0;
        //if total number of start (countS) is less than total number of end, continue...
        // if total number of start == total number of end, now you find the longest distance between start and end, save {start,end} to the list
        for (int i = min; i <= max; i++) {
            if (starts[i] >= 1 && start == -1) {
                start = i;
                sCount += starts[i];
            } else if (starts[i] >= 1) {
                sCount += starts[i];//this MUST + ALL starts!!!!
            }
            if (ends[i] >= 1) {//this MUST - ALL starts!!!!
                sCount -= ends[i];
                if (sCount == 0) {
                    list.add(new int[]{start, i});
                    start = -1; //reset start
                }
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[][] mergeSorting(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        Stack<int[]> queue = new Stack<>();
        for (int[] interval : intervals) {
            if (queue.isEmpty()) {
                queue.add(interval);
            } else {
                int[] pair = queue.peek();
                if ((interval[0] >= pair[0] && interval[0] <= pair[1])
                        || (interval[1] >= pair[0] && interval[1] <= pair[1])) {
                    queue.pop();
                    queue.add(new int[]{Math.min(pair[0], interval[0]), Math.max(pair[1], interval[1])});
                } else {
                    queue.add(interval);
                }
            }
        }
        int res[][] = new int[queue.size()][2];
        int i = 0;
        while (!queue.isEmpty()) {
            res[i] = queue.pop();
            i++;
        }
        return res;
    }

    /**
     * Linked list
     */
    public int[][] merge1(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        LinkedList<int[]> list = new LinkedList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (list.isEmpty() || intervals[i][0] > list.getLast()[1]) {
                list.add(intervals[i]);
                continue;
            }
            if (intervals[i][1] >= list.getLast()[1]) {
                int[] last = list.removeLast();
                list.add(new int[]{Math.min(intervals[i][0], last[0]), Math.max(intervals[i][1], last[1])});
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}
