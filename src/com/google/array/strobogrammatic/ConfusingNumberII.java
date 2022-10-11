package com.google.array.strobogrammatic;

import java.util.HashMap;
import java.util.Map;

public class ConfusingNumberII {
    static Map<Integer, Integer> map = new HashMap<>();

    static {
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
    }

    int res = 0;

    public int confusingNumberII(int N) {
        // begin with cur = 0
        helper(0, N);
        return res;
    }

    private void helper(long cur, int n) {
        if (isConfusingNumber(cur)) {
            res++;
        }
        for (int k : map.keySet()) {
            long next = cur * 10 + k;
            if (next <= n && next != 0) {
                helper(next, n);
            }
        }
    }

    private boolean isConfusingNumber(long cur) {
        long src = cur;
        long res = 0;
        while (cur > 0) {
            res = res * 10 + map.get((int) (cur % 10));
            cur /= 10;
        }
        return src != res;
    }
}
