package com.google.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SingleThreadedCPU {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int taskWithIndex[][] = new int[tasks.length][3];
        for (int i = 0; i < tasks.length; i++) {
            taskWithIndex[i][0] = i;
            taskWithIndex[i][1] = tasks[i][0];
            taskWithIndex[i][2] = tasks[i][1];
        }
        Arrays.sort(taskWithIndex, (a, b) -> (a[1] - b[1]));
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[2] == b[2] ? a[0] - b[0] : a[2] - b[2]));
        int time = 0;

        int index = 0;
        int ai = 0;
        int res[] = new int[n];
        while (ai < n) {
            while (index < n && taskWithIndex[index][1] <= time) {
                queue.add(taskWithIndex[index]);
                index++;
            }
            if (queue.isEmpty()) {
                time = taskWithIndex[index][1];
                continue;
            }
            int t[] = queue.poll();
            res[ai] = t[0];
            ai++;
            time += t[2];
        }

        return res;
    }
}
