package com.algorithms.binary.search;

public class BinarySearch {
    public int search(int[] arr, int target) {
        return search(arr, target, 0, arr.length - 1);
    }

    private int search(int[] arr, int target, int l, int r) {
        if (l > r) return -1;
        int mid = l + (r - l) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return search(arr, target, l, mid);
        } else {
            return search(arr, target, mid, r);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(nums, 6));
    }
}
