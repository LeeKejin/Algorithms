package com.google.array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class StockPrice {
    PriorityQueue<int[]> minQueue = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
    PriorityQueue<int[]> maxQueue = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
    Map<Integer, Integer> map = new HashMap<>();
    int time = 0;

    public StockPrice() {

    }

    public void update(int timestamp, int price) {
        time = Math.max(timestamp, time);

        minQueue.add(new int[]{timestamp, price});
        maxQueue.add(new int[]{timestamp, price});

        map.put(timestamp, price);

    }

    public int current() {
        return map.get(time);
    }

    public int maximum() {
        int maxArr[];

        while (true) {
            maxArr = maxQueue.peek();
            if (map.get(maxArr[0]) == maxArr[1]) {
                break;
            }
            maxQueue.poll();
        }

        return maxArr[1];

    }

    public int minimum() {
        int minArr[];
        while (true) {
            minArr = minQueue.peek();
            if (map.get(minArr[0]) == minArr[1]) {
                break;
            }
            minQueue.poll();
        }
        return minArr[1];
    }
}
