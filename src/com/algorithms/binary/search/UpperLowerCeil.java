package com.algorithms.binary.search;

public class UpperLowerCeil {
    public int findLowerCeil(int[] arr, int target) {
        return findLowerCeil(arr, target, 0, arr.length);
    }

    private int findLowerCeil(int[] arr, int target, int l, int r) {
        if (l > r) return l;
        if (l == r) return l;
        int mid = l + (r - l) / 2;
        if (arr[mid] < target) {
            return findLowerCeil(arr, target, mid + 1, r);
        }
        return findLowerCeil(arr, target, l, mid);
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1, 1, 3, 3, 5, 5, 5, 7, 7};
        UpperLowerCeil ceil = new UpperLowerCeil();
        System.out.println(ceil.findLowerCeil(arr, 5));//4
    }
}
