package com.amazon.interview.greedy;

import java.util.Arrays;

public class Leet135 {
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }

        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = Math.max(right[i + 1] + 1, left[i]);
            } else {
                right[i] = left[i];
            }
        }
        right[right.length - 1] = left[left.length - 1];
        int sum = 0;
        for (int v : right) {
            sum += v;
        }
        return sum;
    }

    public int candyOneArr(int[] ratings) {
        int n = ratings.length;
        int[] candy = new int[n];
        Arrays.fill(candy, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i - 1] < ratings[i]) {
                candy[i] = candy[i - 1] + 1;
            }
        }
        int sum = candy[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i + 1] + 1, candy[i]);
            }
            sum += candy[i];
        }
        return sum;
    }

}
