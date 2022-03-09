package com.google.binary;

import java.util.ArrayList;
import java.util.List;

public class HitCounter {
    List<Integer> list = new ArrayList<>();

    public HitCounter() {

    }

    public void hit(int timestamp) {
        list.add(timestamp);
    }

    public int getHits(int timestamp) {
        int index = find(timestamp);
        if (index == -1) return 0;
        int count = 0;
        if (timestamp - 300 <= 0) {
            return list.size();
        }

        while (index >= 0) {
            if (list.get(index) > timestamp - 300) {
                count++;
                index--;
            } else {
                break;
            }
        }
        return count;
    }

    private int find(int timestamp) {
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) == timestamp) return mid;
            if (list.get(mid) < timestamp) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }
}
