package com.google.greedy;

public class MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if (tops.length <= 1) return 0;
        int maxTop = 0;
        int maxBottom = 0;
        int arrTop[] = new int[7];
        int arrBottom[] = new int[7];
        for (int top : tops) {
            arrTop[top]++;
        }
        int top = -1;

        for (int i = 0; i < arrTop.length; i++) {
            int freq = arrTop[i];
            if (maxTop < freq) {
                top = i;
                maxTop = freq;
            }

        }
        for (int b : bottoms) {
            arrBottom[b]++;
        }
        int bottom = -1;
        for (int i = 0; i < arrBottom.length; i++) {
            int freq = arrBottom[i];
            if (freq > maxBottom) {
                maxBottom = freq;
                bottom = i;
            }
        }
        int start;
        boolean isTop;
        if (maxTop >= maxBottom) {
            start = top;
            isTop = true;
        } else {
            start = bottom;
            isTop = false;
        }

        if (isTop) {
            for (int i = 0; i < tops.length; i++) {
                if (tops[i] == start) continue;
                if (bottoms[i] != start) return -1;
            }
            return tops.length - maxTop;
        }
        for (int i = 0; i < bottoms.length; i++) {
            if (bottoms[i] == start) continue;
            if (tops[i] != start) return -1;
        }
        return bottoms.length - maxBottom;
    }
}
