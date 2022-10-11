package com.google.dp.jumpgame;

public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i > max) return false;
            if (max >= nums.length - 1) return true;
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }

    public boolean canJump1(int[] nums) {
        if (nums.length == 0) return true;
        int max = 0;
        boolean dp[] = new boolean[nums.length];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] || i < max) {
                max = Math.max(max, nums[i] + i);
                if (max >= nums.length - 1) return true;
                dp[max] = true;
            }
        }
        return dp[nums.length - 1];
    }
}
