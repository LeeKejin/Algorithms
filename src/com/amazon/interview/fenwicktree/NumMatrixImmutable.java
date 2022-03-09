package com.amazon.interview.fenwicktree;

public class NumMatrixImmutable {
    class FenwickTree {
        int sum[][];
        int m;
        int n;

        public FenwickTree(int m, int n) {
            sum = new int[m + 1][n + 1];
            this.m = m + 1;
            this.n = n + 1;
        }

        int lowbit(int i) {
            return i & (-i);
        }

        void update(int i, int j, int val) {
            while (i < m) {
                while (j < n) {
                    sum[i][j] += val;
                    j += lowbit(j);
                }
                i += lowbit(i);
            }
        }

        int query(int i, int j) {
            int res = 0;
            while (i > 0) {
                while (j > 0) {
                    res += sum[i][j];
                    j -= lowbit(j);
                }
                i -= lowbit(i);
            }
            return res;
        }
    }

    FenwickTree ft;
    int[][] matrix;

    public NumMatrixImmutable(int[][] matrix) {
        ft = new FenwickTree(matrix.length, matrix[0].length);
        this.matrix = matrix;
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                ft.update(i, j, matrix[i - 1][j - 1]);
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1 + 1; i <= row2 + 1; i++) {
            sum += ft.query(i, col2 + 1) - ft.query(i, col1);
        }
        return sum;
    }
}
