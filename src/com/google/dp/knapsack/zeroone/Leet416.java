package com.google.dp.knapsack.zeroone;

import java.util.Arrays;

public class Leet416 {
    public boolean canPartition(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return false;
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;

        int size = sum / 2 + 1;
        boolean dp[] = new boolean[size];
        dp[0] = true;

        int target = sum / 2;
        for (int i = 1; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];

            }
        }
        return dp[target];
    }

    public boolean canPartitionDP(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return false;

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) return false;
        sum = sum / 2;
        boolean[] dp = new boolean[sum + 1];
        for (int i = 0; i <= sum; i++)
            dp[i] = (nums[0] == i);

        for (int i = 1; i < nums.length; i++) {
            for (int j = sum; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[sum];
    }

    public boolean canPartitionDP1(int[] nums) {
        if (nums.length <= 1) return false;
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        int capacity = sum / 2;

        int dp[] = new int[capacity + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = capacity; j >= nums[i]; j--) {

                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                if (dp[j] == capacity) return true;


            }
        }
        return dp[capacity] == capacity;
    }
}
