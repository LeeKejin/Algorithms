package com.algorithms.binary.search.leetcode;

public class Leet35 {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int left = findLeft(nums, target, 0, nums.length - 1);
        if (nums[left] >= target) return left;

        return left + 1;
    }

    private int findLeft(int[] nums, int target, int l, int r) {
        if (l >= r) return l;
        int mid = l + (r - l) / 2;
        if (target <= nums[mid]) return findLeft(nums, target, l, mid);
        return findLeft(nums, target, mid + 1, r);
    }
}
