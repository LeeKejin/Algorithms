package com.amazon.interview.binarysearch;

public class Leet875 {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Integer.MIN_VALUE;
        for (int p : piles) {
            r = Math.max(p, r);
        }

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (calculateSum(piles, mid) <= h) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int calculateSum(int[] piles, int speed) {
        int sum = 0;
        for (int pile : piles) {
            // 上取整可以这样写
            sum += (pile + speed - 1) / speed;
        }
        return sum;
    }
}
