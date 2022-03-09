package com.google.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> (a[1] - b[1]));
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        for (int i = 0; i < trips.length; i++) {
            if (queue.isEmpty()) {
                if (capacity >= trips[i][0]) {
                    queue.add(trips[i]);
                    capacity -= trips[i][0];
                } else {
                    return false;
                }
            } else {
                while (!queue.isEmpty() && queue.peek()[2] <= trips[i][1]) {
                    capacity += queue.poll()[0];
                }
                if (capacity < trips[i][0]) return false;
                capacity -= trips[i][0];
                queue.add(trips[i]);
            }
        }
        return true;
    }
}
