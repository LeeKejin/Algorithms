package com.algorithms.binary.search.leetcode;

public class Leet33 {
    public int search(int[] nums, int target) {
        return find(nums, 0, nums.length - 1, target);

    }

    private int find(int[] nums, int start, int end, int target) {
        if (start >= end) {
            if (nums[start] == target) return start;
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        if (nums[mid] == target) return mid;
        // order in left
        if (nums[start] < nums[mid]) {
            if (target > nums[start] && target < nums[mid]) return find(nums, start, mid, target);
            return find(nums, mid + 1, end, target);
        }
        // if (nums[mid] < nums[right]) order in right
        if (target > nums[mid] && target < nums[end]) {
            return find(nums, mid + 1, end, target);
        }
        return find(nums, start, mid - 1, target);

    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 7, 0, 1, 2};
        //        int[] arr = ArrayGeneration.generateRandomArrayWithInt( 10000, 10000 );
        Leet33 sort = new Leet33();
        System.out.println(sort.search(arr, 2));
        //        SortingHelper.isSorted( arr );
    }
}
