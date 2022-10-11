package com.google.array;

public class WiggleSort {
    public void wiggleSort(int[] nums) {
        int i = 1;
        while (i < nums.length) {
            if (i % 2 != 0 && nums[i] < nums[i - 1]) {
                swap(nums, i, i - 1);

            } else if (i % 2 == 0 && nums[i] > nums[i - 1]) {
                swap(nums, i, i - 1);

            }
            i++;
        }
    }

    void swap(int[] nums, int x, int y) {
        int t = nums[x];
        nums[x] = nums[y];
        nums[y] = t;
    }
}
