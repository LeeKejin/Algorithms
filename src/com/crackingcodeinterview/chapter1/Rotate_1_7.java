package com.crackingcodeinterview.chapter1;

public class Rotate_1_7 {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                swapUpDpwn(matrix, i, j);
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }
    }

    private void swapUpDpwn(int[][] matrix, int up, int j) {
        int down = matrix.length - up - 1;
        int temp = matrix[up][j];
        matrix[up][j] = matrix[down][j];
        matrix[down][j] = temp;
    }

    public static void main(String[] args) {
        Rotate_1_7 rotate_1_7 = new Rotate_1_7();
        rotate_1_7.rotate(new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        });

    }
}
