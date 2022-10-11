package com.crackingcodeinterview.chapter8;

public class FindMagicIndex_8_3 {
    public int findMagicIndex(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) return i;
        }
        return -1;
    }

    public int findMagicIndex1(int[] nums) {
        return getAnswer(nums, 0, nums.length - 1);
    }

    public int getAnswer(int[] nums, int left, int right) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        int val = getAnswer(nums, left, mid - 1);
        if (val != -1) {
            return val;
        } else if (nums[mid] == mid) {
            return mid;
        }
        return getAnswer(nums, mid + 1, right);
    }

    public static void main(String[] args) {
        FindMagicIndex_8_3 test = new FindMagicIndex_8_3();
        test.findMagicIndex1(new int[]{1, 2, 3, 3, 5});
    }
}
