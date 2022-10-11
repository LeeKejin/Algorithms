package com.google.array;

public class Leet66 {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        int n = digits.length;
        while (i >= 0 && digits[i] == 9) {
            i--;
        }
        if (i == -1) {
            int res[] = new int[n + 1];
            res[0] = 1;
            for (int j = 1; j < res.length; j++) {
                res[j] = 0;
            }
            return res;
        }
        int res[] = new int[n];
        for (int j = 0; j < res.length; j++) {
            if (j == i) {
                res[j] = digits[i] + 1;
            } else if (j > i) {
                res[j] = 0;
            } else {
                res[j] = digits[j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leet66 test = new Leet66();
        test.plusOne(new int[]{129});
    }
}
