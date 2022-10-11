package com.google.dp.jumpgame;

public class VideoStitching {
    public int videoStitching(int[][] clips, int time) {
        int arr[] = new int[time + 1];
        for (int[] clip : clips) {
            if (clip[0] > time) continue;
            arr[clip[0]] = Math.max(arr[clip[0]], clip[1] - clip[0]);
        }
        int max = 0;
        int res = 0;
        int end = 0;
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
