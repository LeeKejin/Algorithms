package com.crackingcodeinterview.chapter8;

public class Multiply_8_5 {
    public int multiply(int A, int B) {
        int max = Math.max(A, B);
        int min = Math.min(A, B);
        int res = 0;
        for (int i = 0; min != 0; i++) {
            if ((min & 1) == 1) {
                res += max << i;
            }
            min >>= 1;
        }
        return res;
    }
}
