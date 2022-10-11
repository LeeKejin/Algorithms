package com.google.array;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagIterator {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    boolean flag = true;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        q1.addAll(v1);
        q2.addAll(v2);
    }

    public int next() {
        if (flag && !q1.isEmpty()) {
            flag = false;
            return q1.poll();
        }
        if (!q2.isEmpty()) {
            flag = true;
            return q2.poll();
        }
        return q1.poll();
    }

    public boolean hasNext() {
        return !q1.isEmpty() || !q2.isEmpty();
    }
}
