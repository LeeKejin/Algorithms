package com.algorithms.dynamicprogramming.singlestring;

import java.util.HashMap;
import java.util.Map;

public class Leet198_Rob {
    Map<Integer, Integer> map = new HashMap<>();
    int dp[][];

    public int robDP(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] rob = new int[nums.length];
        rob[0] = nums[0];
        rob[1] = Math.max(nums[0], nums[1]);
        int res = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            rob[i] = Math.max(rob[i - 1], rob[i - 2] + nums[i]);
            res = Math.max(res, rob[i]);
        }
        return rob[nums.length - 1];
    }

    public int rob1(int[] nums) {
        int dpY[] = new int[nums.length];
        int dpN[] = new int[nums.length];
        dpY[0] = nums[0];
        dpN[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            dpY[i] = Math.max(nums[i] + dpN[i - 1], dpY[i - 1]);
            dpN[i] = dpY[i - 1];
        }
        return Math.max(dpY[nums.length - 1], dpN[nums.length - 1]);
    }

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;

        return amount(nums, nums.length - 1);
    }

    private int amount(int[] nums, int n) {
        if (n == 0) {
            return nums[0];
        }

        int sum1 = nums[n];
        int sum2 = 0;
        int val = 0;
        if (n - 2 >= 0) {
            if (map.containsKey(n - 2)) {
                val = map.get(n - 2);
            } else {
                val = amount(nums, n - 2);
                map.put(n - 2, val);
            }

        }
        sum1 += val;
        if (n - 1 >= 0) {
            if (map.containsKey(n - 1)) {
                sum2 = map.get(n - 1);
            } else {
                sum2 = amount(nums, n - 1);
                map.put(n - 1, sum2);
            }
        }

        return Math.max(sum1, sum2);
    }
}
