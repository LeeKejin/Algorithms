package com.google.slidewindow;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1); //至多有k个的结果-至多有k-1个就是只有k的结果
    }

    public int atMostK(int[] nums, int k) {

        int i = 0;
        int res = 0;
        int start = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (i < nums.length) {
            if (map.getOrDefault(nums[i], 0) == 0) k--;
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (k < 0) {
                map.put(nums[start], map.get(nums[start]) - 1);
                if (map.get(nums[start]) == 0) k++;
                start++;
            }
            res += i - start;
            i++;
        }
        return res;
    }

}
