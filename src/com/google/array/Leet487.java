package com.google.array;

public class Leet487 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i = 0;
        int count = 0;
        int res = 0;
        int zeroIndex = -1;
        boolean isZero = false;
        while (i < nums.length) {
            if (nums[i] == 1 || !isZero) {
                if (nums[i] == 0) {
                    isZero = true;
                    zeroIndex = i;
                }
                count++;
                i++;
            } else {
                res = Math.max(res, count);

                isZero = false;
                count = 0;
                i = zeroIndex + 1;
            }
        }
        res = Math.max(res, count);
        return res;
    }
}
