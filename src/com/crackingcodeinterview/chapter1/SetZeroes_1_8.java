package com.crackingcodeinterview.chapter1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetZeroes_1_8 {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (int i : rows) {
            Arrays.fill(matrix[i], 0);
        }
        for (int j : cols) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][j] = 0;
            }
        }
    }
}
