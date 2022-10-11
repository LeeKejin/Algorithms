package com.google.binary;

import java.util.Arrays;

//https://leetcode.com/problems/divide-chocolate/
public class DivideChocolate {
    public int maximizeSweetness(int[] sweetness, int k) {
        int sum = Arrays.stream(sweetness).sum();
        int l = Arrays.stream(sweetness).min().getAsInt();
        int r = sum;
        int res = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canCut(sweetness, mid, k)) {
                l = mid + 1;
                res = mid;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    private boolean canCut(int[] sweetness, int mid, int k) {
        int cur = 0;
        int sum = 0;
        for (int i = 0; i < sweetness.length; i++) {
            sum += sweetness[i];
            if (sum >= mid) {
                sum = 0;
                cur++;
            }
        }
        return cur > k;
    }
}
