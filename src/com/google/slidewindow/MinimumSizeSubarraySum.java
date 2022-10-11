package com.google.slidewindow;

public class MinimumSizeSubarraySum {
    //O(n)
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int start = 0;
        int res = nums.length + 1;
        while (i < nums.length) {
            target -= nums[i];
            while (target <= 0) {
                res = Math.min(i - start + 1, res);
                target += nums[start];
                start++;

            }
            i++;
        }
        return res == nums.length + 1 ? 0 : res;
    }
}
