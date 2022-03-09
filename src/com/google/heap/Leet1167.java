package com.google.heap;

import java.util.PriorityQueue;

public class Leet1167 {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int s : sticks) {
            queue.add(s);
        }
        if (queue.isEmpty() || queue.size() == 1) return 0;
        int res = 0;
        while (queue.size() > 1) {
            int l = queue.poll() + queue.poll();
            res += l;
            queue.add(l);
        }
        return res;
    }
}
