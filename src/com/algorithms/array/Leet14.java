package com.algorithms.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet14 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length == 0) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] > target) break;
            if (i > 0 && nums[i - 1] == nums[i]) continue;

            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];
                    if (sum == target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        while (start < end && nums[start + 1] == nums[start]) start++;
                        while (start < end && nums[end - 1] == nums[end]) end--;
                        start++;
                        end--;
                    } else if (sum > target) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }
        return list;
    }
}
