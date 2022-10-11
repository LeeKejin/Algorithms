package com.google.dfs;

//shudu
public class Sudoku {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int k = 1; k <= 9; k++) {
                        if (isValid(board, i, j, (char) (k + '0'))) {
                            board[i][j] = (char) (k + '0');
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int x, int y, char ch) {
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == ch) return false;
            if (board[i][y] == ch) return false;
            if (board[3 * (x / 3) + i / 3][3 * (y / 3) + i % 3] == ch) return false;
        }
        return true;
    }
}
