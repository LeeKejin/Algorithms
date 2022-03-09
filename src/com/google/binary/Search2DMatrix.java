package com.google.binary;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 0) return false;
        int l = 0;
        int r = m * n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == matrix[mid / n][mid % n]) return true;
            if (target < matrix[mid / n][mid % n]) {
                r = mid - 1;

            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        int row = binarySearchFirstColumn(matrix, target);
        if (row < 0) {
            return false;
        }
        System.out.println(row);
        int index = findValue(matrix[row], 0, matrix[0].length - 1, target);
        return matrix[row][index] == target;
    }

    private int findValue(int[] row, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (row[mid] == target) return mid;
            if (row[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    //when condition is the first value in the row is bigger than all values in previous row, then using this!!!!
    public int binarySearchFirstColumn(int[][] matrix, int target) {
        int low = 0, high = matrix.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (matrix[mid][0] <= target) {
                low = mid - 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
