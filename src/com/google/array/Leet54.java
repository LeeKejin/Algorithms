package com.google.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Leet54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (matrix.length == 0) return new ArrayList<>();
        if (matrix.length == 1) return Arrays.stream(matrix[0]).boxed().collect(Collectors.toList());
        int up = 0;
        int down = m - 1;
        int left = 0;
        int right = n - 1;
        List<Integer> list = new ArrayList<>();
        while (true) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
            }
            up++;
            if (up > down) break;
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if (right < left) break;

            for (int i = right; i >= left; i--) {
                list.add(matrix[down][i]);
            }
            down--;
            if (down < up) break;
            for (int i = down; i >= up; i--) {
                list.add(matrix[i][left]);
            }
            left++;
            if (left > right) break;
        }
        return list;

    }
}
