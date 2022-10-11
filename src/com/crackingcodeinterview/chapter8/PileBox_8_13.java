package com.crackingcodeinterview.chapter8;

import java.util.Arrays;

public class PileBox_8_13 {
    public int pileBox(int[][] box) {
        Arrays.sort(box, (x, y) -> x[0] - y[0]);
        int[] dp = new int[box.length];
        for (int i = 0; i < box.length; i++) {
            dp[i] = box[i][2];
        }
        int res = 0;
        for (int i = 1; i < box.length; i++) {
            for (int j = 0; j < i; j++) {
                if (box[i][0] > box[j][0] && box[i][1] > box[j][1] && box[i][2] > box[j][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + box[i][2]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return Math.max(res, dp[0]);
    }

    public static void main(String[] args) {
        PileBox_8_13 test = new PileBox_8_13();
        System.out.println(1 ^ 1);
    }
}
