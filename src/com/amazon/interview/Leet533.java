package com.amazon.interview;

import java.util.HashMap;
import java.util.Map;

public class Leet533 {
    public int findBlackPixel(char[][] picture, int target) {
        int res = 0;
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();
        String str = "";
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B') {
                    rowMap.put(i, rowMap.getOrDefault(i, 0) + 1);
                    colMap.put(j, colMap.getOrDefault(j, 0) + 1);
                }
            }
        }
        for (int i = 0; i < picture[0].length; i++) {
            if (!colMap.containsKey(i)) continue;
            if (colMap.get(i) == target) {
                int first = -1;
                int sum = 0;
                for (int j = 0; j < picture.length; j++) {
                    if (picture[j][i] == 'B') {
                        if (rowMap.get(j) != target) break;
                        if (first == -1) first = j;
                        else if (!equals(picture, first, j)) break;
                        sum++;
                    }
                }
                if (sum == target) res += target;
            }

        }
        return res;
    }

    public boolean equals(char[][] picture, int a, int b) {
        for (int i = 0; i < picture[0].length; i++) {
            if (picture[a][i] != picture[b][i]) return false;
        }
        return true;
    }
}
