package com.google.array;

import java.util.Arrays;

public class MinimizeMaximumPairSumInArray {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int res = 0;
        while (i < j) {
            res = Math.max(res, nums[i] + nums[j]);
            i++;
            j--;
        }
        return res;
    }


    public int minPairSumWithoutSorting(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int arr[] = new int[max + 2];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }

        int i = 0;
        int j = max;
        int res = 0;
        while (i < j) {
            while (i < j && arr[i] <= 0) i++;
            while (j > i && arr[j] <= 0) j--;
            res = Math.max(res, i + j);
            arr[i]--;
            arr[j]--;
            if (arr[i] <= 0) i++;
            if (arr[j] <= 0) j--;
        }
        return res;
    }
}
