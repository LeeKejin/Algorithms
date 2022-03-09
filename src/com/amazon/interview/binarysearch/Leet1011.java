package com.amazon.interview.binarysearch;

public class Leet1011 {
    public int shipWithinDays(int[] weights, int days) {
        int r = 0;
        int l = 0;
        for (int w : weights) {
            r += w;
            l = Math.max(l, w);
        }
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(weights, days, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int[] weights, int days, int mid) {
        int count = 1;
        int sum = 0;
        for (int w : weights) {
            if (sum + w > mid) {
                count++;
                sum = 0;
            }
            sum += w;
            if (count > days) return false;
        }
        return true;
    }
}
