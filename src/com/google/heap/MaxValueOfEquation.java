package com.google.heap;

import java.util.PriorityQueue;

public class MaxValueOfEquation {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int res = Integer.MIN_VALUE;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        for (int i = 0; i < points.length; i++) {
            while (!queue.isEmpty() && points[i][0] - queue.peek()[1] > k) {
                queue.poll();
            }
            if (!queue.isEmpty()) {
                res = Math.max(res, points[i][0] + points[i][1] + queue.peek()[0]);
            }
            queue.add(new int[]{points[i][1] - points[i][0], points[i][0]});
        }
        return res;
    }
}
