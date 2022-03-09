package com.amazon.interview;

public class Leet48_high {
    public void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length == 1) return;
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++)//i+1代表递进一层， j在这一层里遍历元素
        {
            for (int j = i; j < n - 1 - i; j++)//从两边往里缩，每循环一轮要排除俩元素 因为上次已经交换过了
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

    public void rotate1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        //Upside down
        for (int i = 0; i < m / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[m - i - 1][j];
                matrix[m - i - 1][j] = temp;
            }
        }
        //swap along top left->down right
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        Leet48_high test = new Leet48_high();
        test.rotate(matrix);
    }
}
