package com.google.array.matrix;

import java.util.ArrayList;
import java.util.List;

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int i = 0;
        List<Integer> list = new ArrayList<>();
        while (i < m + n - 1) {


            int x1 = (i < m) ? i : m - 1;
            int y1 = i - x1;
            while (x1 >= 0 && y1 < n) {
                list.add(mat[x1][y1]);
                x1--;
                y1++;
            }
            i++;
            if (i >= m + n - 1) break;

            int y2 = (i < n) ? i : n - 1;
            int x2 = i - y2;
            while (y2 >= 0 && x2 < m) {
                list.add(mat[x2][y2]);
                x2++;
                y2--;
            }
            i++;
        }
        int res[] = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            res[j] = list.get(j);
        }
        return res;
    }
}
