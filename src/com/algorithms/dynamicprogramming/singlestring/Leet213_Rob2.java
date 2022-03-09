package com.algorithms.dynamicprogramming.singlestring;

import java.util.HashMap;
import java.util.Map;

public class Leet213_Rob2 {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        if (nums.length == 1) return nums[0];

        int c1 = calculateWithRange(nums, 0, nums.length - 1);
        int c2 = calculateWithRange(nums, 1, nums.length);

        return Math.max(c1, c2);
    }

    private int calculateWithRange(int[] nums, int start, int end) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(start, nums[start]);
        for (int i = start + 1; i < end; i++) {
            int sum1 = map.get(i - 1);
            int sum2 = nums[i];
            if (map.get(i - 2) != null) {
                sum2 += map.get(i - 2);
            }
            map.put(i, Math.max(sum1, sum2));
        }
        return Math.max(map.get(end - 1), map.get(end - 2));
    }

    public int rob1(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int dp[] = new int[nums.length];
        int n = nums.length;
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        if (nums.length == 2) return dp[1];
        for (int i = 2; i < n - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        int res = dp[n - 2];

        dp[1] = nums[1];
        dp[2] = Math.max(nums[1], nums[2]);
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        res = Math.max(dp[n - 1], res);

        return res;
    }
}
