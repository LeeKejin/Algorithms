package com.algorithms.array.leetcode;

/*
https://leetcode.com/problems/find-the-duplicate-number/ -> Leet287
https://leetcode.com/problems/missing-number/ -> Leet268
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/ -> Leet 448
 */
public class Leet41 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //add num[] is for dealing with duplication like [1,1], without num[], it's a dead loop!!!
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) return i + 1;
        }
        return nums.length + 1;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
