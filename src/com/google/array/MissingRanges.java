package com.google.array;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int next = lower;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < next) continue;
            if (nums[i] == next) {
                next++;
                continue;
            }
            String range = generateRange(next, nums[i] - 1);
            res.add(range);
            next = nums[i] + 1;
        }
        if (next <= upper) {
            res.add(generateRange(next, upper));
        }

        return res;
    }

    private String generateRange(int next, int num) {
        if (next == num) return num + "";
        return next + "->" + num;
    }
}
