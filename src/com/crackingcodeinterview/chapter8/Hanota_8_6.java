package com.crackingcodeinterview.chapter8;

import java.util.List;

public class Hanota_8_6 {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A.size(), A, B, C);
    }

    private void move(int size, List<Integer> a, List<Integer> b, List<Integer> c) {
        if (size == 1) {
            c.add(a.get(a.size() - 1));
            a.remove(a.size() - 1);
            return;
        }
        move(size - 1, a, c, b);
        c.add(a.get(a.size() - 1));
        a.remove(a.size() - 1);
        move(size - 1, b, a, c);
    }
}
