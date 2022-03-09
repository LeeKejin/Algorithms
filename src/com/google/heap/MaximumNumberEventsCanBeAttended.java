package com.google.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
O(d + nlogn)
 */
public class MaximumNumberEventsCanBeAttended {
    public int maxEvents(int[][] events) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Arrays.sort(events, (a, b) -> (a[0] - b[0]));
        int i = 0;
        int res = 0;
        int n = events.length;
        int d = 1;
        while (d <= 100000) {
            while (!queue.isEmpty() && queue.peek() < d) {
                queue.poll();
            }
            while (i < n && events[i][0] == d) {
                queue.add(events[i][1]);
                i++;
            }
            if (!queue.isEmpty()) {
                queue.poll();
                res++;
            }
            if (queue.isEmpty() && i == n) {
                break;
            }
            d++;
        }
        return res;
    }

    public int maxEvents1(int[][] events) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Arrays.sort(events, (a, b) -> (a[0] - b[0]));
        int i = 0;
        int res = 0;
        int n = events.length;
        int d = 1;
        while (i != n || !queue.isEmpty()) {
            while (!queue.isEmpty() && queue.peek() < d) {
                queue.poll();
            }
            while (i < n && events[i][0] == d) {
                queue.add(events[i][1]);
                i++;
            }
            if (!queue.isEmpty()) {
                queue.poll();
                res++;
            }

            d++;
        }
        return res;
    }
}
