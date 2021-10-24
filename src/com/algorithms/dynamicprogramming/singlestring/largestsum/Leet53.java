package com.algorithms.dynamicprogramming.singlestring.largestsum;

public class Leet53 {

    public int findMaxSumSubArray(int[] arr) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int max = arr[i];
            int temp = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                temp += arr[j];
                max = Math.max(max, temp);
            }
            res = Math.max(res, max);
        }
        return res;
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int max = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max + nums[i], nums[i]);
            result = Math.max(result, max);
        }
        return result;
    }

    public int maxSubArrayWithBinarySearch(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return binarySearch(nums, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int l, int r) {
        if (l == r) return nums[l];
        int mid = l + (r - l) / 2;
        int leftRes = binarySearch(nums, l, mid);
        int rightRes = binarySearch(nums, mid + 1, r);

        int resOfTwoSides = Math.max(leftRes, rightRes);

        int leftCrossMax = Integer.MIN_VALUE;
        int leftCrossSum = 0;
        for (int i = mid; i >= l; i--) {
            leftCrossSum += nums[i];
            leftCrossMax = Math.max(leftCrossMax, leftCrossSum);
        }

        int rightCrossMax = Integer.MIN_VALUE;
        int rightCrossSum = 0;
        for (int i = mid + 1; i <= r; i++) {
            rightCrossSum += nums[i];
            rightCrossMax = Math.max(rightCrossMax, rightCrossSum);
        }
        return Math.max(resOfTwoSides, rightCrossMax + leftCrossMax);
    }

}
