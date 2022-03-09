package com.amazon.interview.dp.prefix;

import java.util.Random;

public class RandomPickWeight {

    int[] preSum;
    Random random = new Random();

    public RandomPickWeight(int[] w) {
        preSum = new int[w.length + 1];

        for (int i = 0; i < w.length; i++) {
            preSum[i + 1] = w[i] + preSum[i];
        }
    }

    public int pickIndex() {
        int target = random.nextInt(preSum[preSum.length - 1]);
        int l = 0;
        int r = preSum.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (preSum[mid] == target) return mid;
            if (preSum[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (l == preSum.length) return preSum.length - 2;
        return l - 1;
    }

}
