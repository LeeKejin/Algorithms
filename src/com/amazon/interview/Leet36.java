package com.amazon.interview;

public class Leet36 {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][10];
        int[][] column = new int[9][10];
        int[][] box = new int[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch == '.') continue;
                int num = board[i][j] - '0';
                if (row[i][num] == 1) return false;
                if (column[j][num] == 1) return false;
                if (box[j / 3 + (i / 3) * 3][num] == 1) return false;


                row[i][num] = 1;
                column[j][num] = 1;
                box[j / 3 + (i / 3) * 3][num] = 1;
            }
        }
        return true;
    }
}
