package com.google.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Leet218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> list = new ArrayList<>();
        for (int[] building : buildings) {
            list.add(new int[]{building[0], building[2]});
            list.add(new int[]{building[1], -building[2]});
        }
        //border sorted by ascending, but building by descending->new int[][]{{0, 2, 3}, {2, 5, 3}}
        //or output is(0,3)(2,0)(2,3)(5.0) not (0,3)(5,0)
        list.sort((a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        int prev = 0;
        queue.add(0);
        for (int[] building : list) {
            int border = building[0];
            int height = building[1];
            if (height > 0) {
                queue.add(height);
            } else {
                queue.remove(-height);
            }
            int cur = queue.peek();
            if (cur != prev) {
                res.add(Arrays.asList(border, cur));
                prev = cur;
            }
        }
        return res;
    }

    public List<List<Integer>> getSkylineDelayDelete(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> list = new ArrayList<>();
        for (int[] building : buildings) {
            list.add(new int[]{building[0], building[2]});
            list.add(new int[]{building[1], -building[2]});
        }
        list.sort((a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        queue.add(0);
        int prev = 0;
        Map<Integer, Integer> deleteElementAndFreq = new HashMap<>();
        for (int[] building : list) {
            int h = building[1];
            int boarder = building[0];
            if (h > 0) {
                queue.add(h);
            } else {
                deleteElementAndFreq.put(-h, deleteElementAndFreq.getOrDefault(-h, 0) + 1);
            }
            while (!queue.isEmpty()) {
                int max = queue.peek();
                if (deleteElementAndFreq.containsKey(max)) {
                    deleteElementAndFreq.put(max, deleteElementAndFreq.get(max) - 1);
                    if (deleteElementAndFreq.get(max) == 0) {
                        deleteElementAndFreq.remove(max);
                    }
                    queue.poll();
                } else {
                    break;
                }
            }
            int cur = queue.peek();
            if (cur != prev) {
                res.add(Arrays.asList(boarder, cur));
                prev = cur;
            }
        }
        return res;
    }
}
