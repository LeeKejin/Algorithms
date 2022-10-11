package com.crackingcodeinterview.chapter10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Merge_10_1 {
    public void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1;
        int j = n - 1;
        int p = A.length - 1;
        while (p >= 0) {
            if (i < 0) {
                A[p] = B[j];
                j--;
            } else if (j < 0) {
                A[p] = A[i];
                i--;
            } else {
                if (A[i] < B[j]) {
                    A[p] = B[j];
                    j--;
                } else {
                    A[p] = A[i];
                    i--;
                }
            }
            p--;
        }
    }

    public static void main(String[] args) {
        Merge_10_1 test = new Merge_10_1();
    }


}

