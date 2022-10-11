package com.algorithms.dynamicprogramming.singlestring.longestincreasingsubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet300 {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
            } else {
                int index = binary(list, nums[i]);
                list.set(index, nums[i]);
            }
        }
        return list.size();
    }

    //greater then num
    private int binary(List<Integer> list, int num) {
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {

            int mid = l + (r - l) / 2;
            if (list.get(mid) == num) return mid;
            if (list.get(mid) > num) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public int lengthOfLISDP(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                res = Math.max(dp[i], res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leet300 test = new Leet300();
        test.lengthOfLISDP(new int[]{10, 9, 2, 5, 3, 7});
    }
}
