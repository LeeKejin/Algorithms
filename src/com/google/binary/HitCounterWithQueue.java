package com.google.binary;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounterWithQueue {
    Queue<Integer> queue = new LinkedList<>();

    public HitCounterWithQueue() {

    }

    public void hit(int timestamp) {
        queue.add(timestamp);
    }

    public int getHits(int timestamp) {
        while (!queue.isEmpty() && queue.peek() <= (timestamp - 300)) {
            queue.poll();
        }
        return queue.size();
    }
}
