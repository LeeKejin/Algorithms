package com.google.dp;

import java.util.TreeMap;

public class OddEvenJump {
    //O(NlogN)
    public int oddEvenJumps(int[] arr) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int n = arr.length;
        treeMap.put(arr[n - 1], n - 1);
        boolean[][] dp = new boolean[n][2];
        dp[n - 1][0] = true;
        dp[n - 1][1] = true;
        int res = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            Integer nextOdd = treeMap.ceilingKey(arr[i]);
            if (nextOdd != null) dp[i][0] = dp[nextOdd][1];
            Integer nextEven = treeMap.floorKey(arr[i]);
            if (nextEven != null) dp[i][1] = dp[nextEven][0];
            treeMap.put(arr[i], i);
            if (dp[i][0]) res++;

        }
        return res;
    }
}
