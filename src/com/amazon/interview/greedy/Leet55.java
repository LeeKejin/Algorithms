package com.amazon.interview.greedy;

public class Leet55 {
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
        if (nums.length <= 1) return true;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i > max) return false;
            if (max >= nums.length - 1) return true;
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }
}
