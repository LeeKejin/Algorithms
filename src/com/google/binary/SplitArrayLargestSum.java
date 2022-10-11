package com.google.binary;

import java.util.Arrays;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        if (m == 0) return 0;
        int sum = Arrays.stream(nums).sum();
        if (m == 1) return sum;
        int l = Arrays.stream(nums).max().getAsInt();
        if (m >= nums.length) return l;


        int r = sum;
        int res = sum;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int v = canSplit(nums, mid, m);

            if (v == -1) {
                l = mid + 1;
            } else {
                r = mid - 1;
                res = Math.min(res, v);
            }
        }
        return res;
    }

    private int canSplit(int[] nums, int mid, int m) {
        int cur = 0;
        int i = 0;
        int sum = 0;
        int v = 0;
        while (i < nums.length) {
            sum += nums[i];
            if (sum > mid) {
                v = Math.max(v, sum - nums[i]);
                sum = nums[i];

                cur++;
            }
            i++;
        }
        if (cur > m - 1) return -1;
        return Math.max(sum, v);
    }

    //if use the method, res=mid
    //  private boolean canSplit(int[] nums, int mid, int m) {
    //     int cur = 0;
    //     int i = 0;
    //     int sum = 0;
    //     while (i < nums.length) {
    //         sum += nums[i];
    //         if (sum > mid) {
    //             sum = nums[i];
    //             cur++;
    //         }
    //         i++;
    //     }
    //     if (cur > m-1) return false;
    //     return true;
    // }
}
