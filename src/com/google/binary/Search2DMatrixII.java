package com.google.binary;

public class Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        return search(matrix, target, 0, n - 1, 0, m - 1);
    }

    private boolean search(int[][] matrix, int target, int left, int right, int up, int down) {
        if (left > right || up > down) return false;
        if (target < matrix[up][left] || target > matrix[down][right]) return false;
        int mid = left + (right - left) / 2;
        int row = up;
        while (row <= down && target >= matrix[row][mid]) {
            if (target == matrix[row][mid]) return true;
            row++;
        }
        return search(matrix, target, left, mid - 1, row, down) || search(matrix, target, mid + 1, right, up, row - 1);
    }

}
