package com.algorithms.binary.search.leetcode;

public class Leet34 {
    public int[] searchRange(int[] nums, int target) {
        int left = findBound(nums, target, true);
        if (left == -1) return new int[]{-1, -1};
        int right = findBound(nums, target, false);
        return new int[]{left, right};
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                if (isFirst) {
                    if (mid == l || nums[mid - 1] != target) return mid;
                    r = mid - 1;
                } else {
                    if (mid == r || nums[mid + 1] != target) return mid;
                    l = mid + 1;
                }
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
