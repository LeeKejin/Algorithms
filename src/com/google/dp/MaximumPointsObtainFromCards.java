package com.google.dp;

import java.util.Arrays;

public class MaximumPointsObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        if (cardPoints.length <= k) {
            return Arrays.stream(cardPoints).sum();
        }
        if (k == 1) return Math.max(cardPoints[0], cardPoints[cardPoints.length - 1]);
        int before[] = new int[k];
        before[0] = cardPoints[0];
        for (int i = 1; i < k; i++) {
            before[i] = cardPoints[i] + before[i - 1];
        }

        int after[] = new int[k];
        after[k - 1] = cardPoints[cardPoints.length - 1];
        int j = k - 2;
        for (int i = cardPoints.length - 2; i >= cardPoints.length - k; i--) {
            after[j] = cardPoints[i] + after[j + 1];
            j--;

        }
        int res = Math.max(after[0], before[k - 1]);
        for (int i = 0; i < k - 1; i++) {
            res = Math.max(res, after[i + 1] + before[i]);
        }

        return res;
    }
}
