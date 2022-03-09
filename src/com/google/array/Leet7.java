package com.google.array;

public class Leet7 {
    public int reverse(int x) {
        int res = 0;
        int max = Integer.MAX_VALUE / 10;
        int min = Integer.MIN_VALUE / 10;
        while (x != 0) {
            int v = x % 10;
            x /= 10;
            res = res * 10 + v;
            if ((res > max || res < min) && x != 0) return 0;
        }

        return res;
    }
}
