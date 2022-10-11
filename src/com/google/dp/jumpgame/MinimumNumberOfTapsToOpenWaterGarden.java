package com.google.dp.jumpgame;

public class MinimumNumberOfTapsToOpenWaterGarden {
    public int minTaps(int n, int[] ranges) {
        int arr[] = new int[n + 1];
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i] == 0) continue;
            int left = Math.max(0, i - ranges[i]);
            int right = Math.min(n, i + ranges[i]);
            arr[left] = Math.max(arr[left], right - left);
        }

        int max = 0;
        int end = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, i + arr[i]);
            if (i == end) {
                if (end == arr.length - 1) return res;
                res++;
                end = max;
            }
            if (i > end) return -1;
        }
        return res;

    }
}
