package com.amazon.interview.dp.prefix;

public class Leet370 {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];
        for (int[] update : updates) {
            nums[update[0]] += update[2];
            if (update[1] + 1 < length) {
                nums[update[1] + 1] -= update[2];
            }
        }
        for (int i = 1; i < length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
