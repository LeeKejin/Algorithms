package com.crackingcodeinterview.chapter10;

public class SearchMatrix_10_9 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int row = find(matrix, target);
        int n = matrix[0].length - 1;
        while (row >= 0) {
            if (matrix[row][0] <= target && target <= matrix[row][n]) {
                int l = 0;
                int r = n;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (matrix[row][mid] == target) return true;
                    if (target < matrix[row][mid]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
            }
            row--;
        }
        return false;
    }

    //1，2，3，10，18
//返回大于等于target的最小值，if target=0 return 1
    //if target=5 return 3
    //if target=10 return 3
    //if target=19 return 4
    //1，2，3，3，18 if target =3 return 2
    private int find(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (target <= matrix[mid][0]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        SearchMatrix_10_9 test = new SearchMatrix_10_9();
        test.searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {3, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 3);
    }
}
