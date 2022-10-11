package com.google.slidewindow;

public class BinarySubarraysWithSum {
    //https://leetcode.com/problems/binary-subarrays-with-sum/discuss/186683/C%2B%2BJavaPython-Sliding-Window-O(1)-Space
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMostK(nums, goal) - atMostK(nums, goal - 1);
    }

    private int atMostK(int[] nums, int goal) {
        if (goal < 0) return 0;
        int i = 0;
        int start = 0;
        int res = 0;
        while (i < nums.length) {
            goal -= nums[i];
            while (goal < 0) {
                goal += nums[start];
                start++;
            }
            res += i - start + 1;
            i++;
        }
        return res;
    }
}
