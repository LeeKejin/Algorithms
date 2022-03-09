package com.google.array;

public class ShortestSubarrayRemovedToMakeArraySorted {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int i = 0, j = n - 1;
        int maxSeen = 0;
        while (i < n && arr[i] >= maxSeen) {
            maxSeen = arr[i];
            i++;
        }
        int minSeen = Integer.MAX_VALUE;
        while (j >= 0 && arr[j] <= minSeen) {
            minSeen = arr[j];
            j--;
        }
        int shortestSubarry = Math.min(n - i, j + 1);
        if (i == n || j == -1) {
            return shortestSubarry;
        }
        for (int k = 0; k < i; k++) {
            int lo = binarySearch(arr, j + 1, n - 1, arr[k]);
            if (lo == -1) {
                continue;
            }
            shortestSubarry = Math.min(shortestSubarry, lo - k - 1);
        }
        return shortestSubarry;
    }

    private int binarySearch(int[] arr, int lo, int hi, int value) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] >= value) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return arr[lo] >= value ? lo : -1;
    }

    public int findLengthOfShortestSubarraySlidingWindow(int[] arr) {
        int n = arr.length;
        int i = 0, j = n - 1;
        int maxSeen = 0;
        while (i < n && arr[i] >= maxSeen) {
            maxSeen = arr[i];
            i++;
        }
        int minSeen = Integer.MAX_VALUE;
        while (j >= 0 && arr[j] <= minSeen) {
            minSeen = arr[j];
            j--;
        }
        int shortestSubarry = Math.min(n - i, j + 1);
        if (i == n || j == -1) {
            return shortestSubarry;
        }
        int lo = 0, hi = j + 1;
        while (lo < i && hi < arr.length) {
            if (arr[hi] >= arr[lo]) {
                shortestSubarry = Math.min(shortestSubarry, hi - lo - 1);
                lo++;
            } else {
                hi++;
            }
        }
        return shortestSubarry;
    }
}
