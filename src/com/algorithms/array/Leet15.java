package com.algorithms.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int start = i + 1;
            int end = nums.length - 1;

            while (end > start) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    while (start < end && nums[start + 1] == nums[start]) start++;
                    while (start < end && nums[end - 1] == nums[end]) end--;
                    start++;
                    end--;
                } else if (sum < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return res;
    }
}
