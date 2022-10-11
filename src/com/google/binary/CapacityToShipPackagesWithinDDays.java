package com.google.binary;

import java.util.Arrays;

//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int sum = Arrays.stream(weights).sum();
        int l = Arrays.stream(weights).max().getAsInt();
        int r = sum;
        int res = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canShip(weights, days, mid)) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    private boolean canShip(int[] weights, int days, int mid) {
        int sum = 0;
        int cur = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            if (sum > mid) {
                sum = weights[i];
                cur++;
            }
        }
        return cur < days;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 1, 2};
        CapacityToShipPackagesWithinDDays search = new CapacityToShipPackagesWithinDDays();
        System.out.println(search.shipWithinDays(arr, 4));
    }
}
