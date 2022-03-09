package com.amazon.interview.greedy;

/*
https://leetcode.com/problems/jump-game/ -> Leet55
https://leetcode.com/problems/jump-game-iii/ -> Leet1306
 */
public class Leet45 {
    public int jump(int[] nums) {
        int res = 0;
        int start = 0;
        int end = 1;
        while (end < nums.length) {
            int max = 0;
            for (int i = start; i < end; i++) {
                max = Math.max(max, i + nums[i]);
            }
            start = end;
            end = max + 1;
            res++;
        }
        return res;
    }

    public int jump1(int[] nums) {
        int res = 0;
        int end = 0;
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {

            max = Math.max(max, i + nums[i]);
            if (i == end) {
                res++;
                end = max;
            }
        }
        return res;
    }

    public int jump2(int[] nums) {
        int max = 0;
        int end = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (end == i) {
                steps++;
                if (max >= nums.length - 1) return steps;
                end = max;
            }
        }
        return 0;
    }
}
