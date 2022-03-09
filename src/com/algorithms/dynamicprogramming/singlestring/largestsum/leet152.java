package com.algorithms.dynamicprogramming.singlestring.largestsum;

public class leet152 {

    public int maxProduct1(int[] nums) {
        int max = nums[0];
        int res = nums[0];
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tempMax = max;
            int tempMin = min;
            max = Math.max(nums[i], Math.max(nums[i] * tempMax, nums[i] * tempMin));
            min = Math.min(nums[i], Math.min(nums[i] * tempMax, nums[i] * tempMin));
            res = Math.max(res, max);
        }
        return res;
    }
}
