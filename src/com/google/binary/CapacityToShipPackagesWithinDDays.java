package com.google.binary;

public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        if (days == 0) return 0;
        int l = 0;
        int r = 0;
        for (int w : weights) {
            l = Math.max(l, w);
            r += w;
        }
        int res = r;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(mid, weights, days)) {
                res = Math.min(mid, res);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (check(r, weights, days)) return Math.min(r, res);
        return res;
    }

    private boolean check(int mid, int[] weights, int days) {
        int load = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > mid) return false;
            if (load + weights[i] > mid) {
                load = 0;
                days--;
            }
            load += weights[i];
        }
        return days >= 1;
    }

}
