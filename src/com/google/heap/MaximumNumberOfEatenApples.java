package com.google.heap;

import java.util.PriorityQueue;

public class MaximumNumberOfEatenApples {
    public int eatenApples(int[] apples, int[] days) {
        int sum = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        int i = 0;
        while (i < days.length || !queue.isEmpty()) {
            while (!queue.isEmpty() && queue.peek()[1] <= i) {
                queue.poll();
            }
            if (i < apples.length && apples[i] > 0) {
                queue.add(new int[]{apples[i], i + days[i]});
            }
            if (!queue.isEmpty()) {
                int[] arr = queue.poll();
                sum++;
                arr[0]--;
                if (arr[0] != 0) {
                    queue.add(arr);
                }
            }

            i++;
        }
        return sum;
    }
}
