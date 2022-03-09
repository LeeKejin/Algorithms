package com.google.dp;

import java.util.HashMap;
import java.util.Map;

public class Leet1218 {
    public int longestSubsequence(int[] arr, int difference) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i] - difference;
            if (map.containsKey(val)) {
                map.put(arr[i], map.get(val) + 1);
            } else {
                map.put(arr[i], 1);
            }
            res = Math.max(map.get(arr[i]), res);
        }
        return res;
    }
}
