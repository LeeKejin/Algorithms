package com.google.slidewindow;

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        return atMostK(nums, k);
    }

    private int atMostK(int[] nums, int k) {
        int i = 0;
        int start = 0;
        int res = 0;
        while (i < nums.length) {
            if (nums[i] == 0) k--;
            while (k < 0) {
                if (nums[start] == 0) k++;
                start++;
            }
            res = Math.max(res, i - start + 1);
            i++;
        }
        return res;
    }
}
