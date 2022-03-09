package com.google.array;

import java.util.HashSet;
import java.util.Set;

public class Leet41 {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int num : nums) {
            if (num <= 0) continue;
            set.add(num);
            max = Math.max(max, num);
        }
        for (int i = 1; i < max; i++) {
            if (!set.contains(i)) return i;
        }
        return max + 1;

    }

    public int firstMissingPositiveFast(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] < nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) return i + 1;
        }
        return nums.length + 1;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
