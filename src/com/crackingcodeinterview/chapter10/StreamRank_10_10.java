package com.crackingcodeinterview.chapter10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StreamRank_10_10 {
    List<Integer> list = new LinkedList<>();

    public void track(int x) {
        if (list.isEmpty()) {
            list.add(x);
            return;
        }
        int l = 0;
        int r = list.size() - 1;
        r = find(x, l, r);
        if (r == list.size() - 1) {
            list.add(x);
        } else {
            list.add(r, x);
        }
    }

    private int find(int x, int l, int r) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (x <= list.get(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    public int getRankOfNumber(int x) {
        int r = find(x, 0, list.size() - 1);
        if (list.get(r) == x) {
            while (r < list.size() && list.get(r) == x) {
                r++;
            }
        }
        return r;
    }
}
