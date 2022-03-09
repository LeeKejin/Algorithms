package com.amazon.interview.dp.prefix;

import java.util.HashMap;
import java.util.Map;

public class Leet560 {
    public int subarraySum(int[] nums, int k) {
        int preSum[] = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int count = 0;
        for (int i = 0; i <= nums.length; i++) {
            for (int j = i + 1; j <= nums.length; j++) {
                if (preSum[j] - preSum[i] == k) count++;
            }
        }
        return count;
    }

    public int subarraySum1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
