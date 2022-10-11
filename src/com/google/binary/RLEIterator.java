package com.google.binary;

import java.util.ArrayList;
import java.util.List;

public class RLEIterator {
    class State {
        int val;
        long freq;

        public State(int val, long freq) {
            this.val = val;
            this.freq = freq;
        }
    }

    List<State> list = new ArrayList<>();
    long count = 0;

    public RLEIterator(int[] encoding) {

        long sum = 0;
        for (int i = 0; i < encoding.length; i += 2) {
            if (encoding[i] == 0) continue;
            sum += encoding[i];
            list.add(new State(encoding[i + 1], sum));
        }
    }

    public int next(int n) {
        count += n;
        int index = binarySearch(0, count);
        if (index == list.size()) return -1;
        return list.get(index).val;
    }

    private int binarySearch(int l, long n) {
        int r = list.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid).freq == n) return mid;
            if (list.get(mid).freq < n) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
