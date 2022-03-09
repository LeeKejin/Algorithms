package com.algorithms.binary.search;

public class Leet1283 {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int start = 1;
        int end = max + 1;
        int res = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isLessThenThreshold(mid, nums, threshold)) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    private boolean isLessThenThreshold(int mid, int[] nums, int threshold) {
        int sum = 0;
        for (int num : nums) {
            sum += (mid + num - 1) / mid;
            if (sum > threshold) return false;
        }
        return true;
    }
}
