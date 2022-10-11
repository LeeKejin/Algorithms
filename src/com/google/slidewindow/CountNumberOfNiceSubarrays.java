package com.google.slidewindow;

public class CountNumberOfNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {
        int i = 0;
        int start = 0;
        int res = 0;
        while (i < nums.length) {
            if (nums[i] % 2 != 0) k--;

            while (k < 0) {
                if (nums[start] % 2 != 0) k++;
                start++;
            }
            res += i - start;
            i++;
        }
        return res;
    }
}
