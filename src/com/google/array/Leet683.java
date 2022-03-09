package com.google.array;

import java.util.TreeSet;

public class Leet683 {
    public int kEmptySlots(int[] bulbs, int k) {
        if (bulbs.length <= 1) return -1;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < bulbs.length; i++) {
            Integer low = set.lower(bulbs[i]);
            if (low != null && bulbs[i] - low == k + 1) {
                return i + 1;
            }
            Integer high = set.higher(bulbs[i]);
            if (high != null && high - bulbs[i] == k + 1) {
                return i + 1;
            }
            set.add(bulbs[i]);
        }
        return -1;
    }

    public int kEmptySlots1(int[] flowers, int k) {
        int[] days = new int[flowers.length + 1];
        for (int i = 0; i < flowers.length; i++) {
            days[flowers[i]] = i + 1;
        }

        int result = Integer.MAX_VALUE;

        for (int i = 1; i < days.length - k - 1; i++) {
            int l = days[i];
            int r = days[i + k + 1];

            int max = Math.max(l, r);
            int min = Math.min(l, r);


            boolean flag = true;
            for (int j = 1; j <= k; j++) {
                if (days[i + j] < max) {
                    flag = false;
                    break;
                }
            }

            if (flag && max < result) {
                result = max;
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
