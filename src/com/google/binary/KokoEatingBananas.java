package com.google.binary;

import java.util.Arrays;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {

        int r = Arrays.stream(piles).max().getAsInt();
        int l = 1;
        while (r > l) {
            int mid = l + (r - l) / 2;
            if (possible(mid, piles, h)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    private boolean possible(int mid, int[] piles, int h) {
        int count = 0;
        for (int pile : piles) {
            count += pile / mid;
            if (pile % mid != 0) count++;
        }
        return count <= h;
    }

}
