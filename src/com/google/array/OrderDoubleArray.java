package com.google.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OrderDoubleArray {
    public boolean canReorderDoubled(int[] A) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int val : A) {
            freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
        }
        Integer orderedA[] = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            orderedA[i] = A[i];
        }
        Arrays.sort(orderedA, (a, b) -> (Math.abs(a) - Math.abs(b)));

        for (int val : orderedA) {
            if (freqMap.get(val) == 0) continue;
            freqMap.put(val, freqMap.get(val) - 1);

            int v = val * 2;
            int freq = freqMap.getOrDefault(v, 0);
            if (freq == 0) return false;
            freqMap.put(v, freqMap.get(v) - 1);
        }
        return true;
    }
}
