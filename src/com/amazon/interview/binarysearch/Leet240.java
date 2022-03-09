package com.amazon.interview.binarysearch;

public class Leet240 {
    //Cannot do binary search to find floor (biggest value smaller than target), check diff with leet 74!!!
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        for (int i = 0; i <= m; i++) {
            if (matrix[i][0] > target) return false;
            if (matrix[i][n] < target) continue;
            int index = search(matrix[i], target);
            if (matrix[i][index] == target) return true;
        }
        return false;
    }

    private int search(int[] row, int target) {
        int start = 0;
        int end = row.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (row[mid] == target) return mid;
            if (row[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}
