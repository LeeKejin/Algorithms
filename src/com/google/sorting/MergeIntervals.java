package com.google.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        Queue<int[]> queue = new LinkedList<>();
        Arrays.sort(intervals, ((a, b) -> (a[0] - b[0])));
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (queue.isEmpty()) {
                queue.add(intervals[i]);
            } else {
                if (queue.peek()[0] <= intervals[i][0] && intervals[i][0] <= queue.peek()[1]) {
                    int[] existing = queue.poll();
                    queue.add(new int[]{Math.min(existing[0], intervals[i][0]), Math.max(existing[1], intervals[i][1])});
                } else {
                    list.add(queue.poll());
                    queue.add(intervals[i]);
                }
            }
        }
        if (!queue.isEmpty()) {
            list.add(queue.poll());
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
