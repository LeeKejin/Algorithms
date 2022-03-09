package com.amazon.interview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Leet347 {
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List[] arr = new ArrayList[nums.length + 1];
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (arr[freq] == null) {
                arr[freq] = new ArrayList();
            }
            arr[freq].add(key);
        }
        int j = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (list.size() == k) break;
            if (arr[i] == null) {
                continue;
            }
            list.addAll(arr[i]);
        }
        int res[] = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0) return new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                int freq = map.get(num);
                freq++;
                map.put(num, freq);
            } else {
                map.put(num, 1);
            }
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(b) - map.get(a);
            }
        });

        for (int key : map.keySet()) {
            priorityQueue.add(key);
        }

        int[] res = new int[k];
        int i = 0;
        while (!priorityQueue.isEmpty()) {
            res[i] = priorityQueue.poll();
            if (i == k - 1) break;
            i++;
        }
        return res;
    }
}
