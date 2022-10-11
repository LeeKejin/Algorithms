package com.google.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int h : hand) {
            map.put(h, map.getOrDefault(h, 0) + 1);
        }
        Arrays.sort(hand);
        for (int i = hand.length - 1; i >= 0; i--) {
            if (!check(groupSize, map, hand[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean check(int groupSize, Map<Integer, Integer> map, int val) {
        if (!map.containsKey(val)) return true;
        for (int k = 0; k < groupSize; k++) {
            if (!map.containsKey(val)) return false;
            map.put(val, map.get(val) - 1);
            if (map.get(val) == 0) map.remove(val);
            val--;
        }
        return true;
    }
}
