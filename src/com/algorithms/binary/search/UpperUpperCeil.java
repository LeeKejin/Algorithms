package com.algorithms.binary.search;

public class UpperUpperCeil {
    public int findCeil(int[] arr, int target) {
        int upper = findUpper(arr, target);
        if (arr[upper - 1] == target) return upper - 1;
        return upper;
    }

    private int findUpper(int[] arr, int target) {
        return findUpper(arr, target, 0, arr.length);
    }

    private int findUpper(int[] arr, int target, int l, int r) {
        if (l > r) return -1;
        if (l == r) return l;
        int mid = l + (r - l) / 2;
        if (arr[mid] <= target) {
            return findUpper(arr, target, mid + 1, r);
        }
        return findUpper(arr, target, l, mid);
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1, 1, 3, 3, 5, 5, 5, 7, 7};
        UpperUpperCeil ceil = new UpperUpperCeil();
        System.out.println(ceil.findCeil(arr, 5));//6
    }
}
