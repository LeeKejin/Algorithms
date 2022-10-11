package com.google.array;

import java.util.List;

public class ZigzagIteratorWithoutQ {
    int i = 0;
    int j = 0;
    boolean flag = true;
    List<Integer> v1;
    List<Integer> v2;

    public ZigzagIteratorWithoutQ(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public int next() {
        if ((flag && i < v1.size()) || j == v2.size()) {
            int v = v1.get(i);
            i++;
            flag = false;
            return v;
        }
        int v = v2.get(j);
        j++;
        flag = true;
        return v;
    }

    public boolean hasNext() {
        return i < v1.size() || j < v2.size();
    }
}
