package com.crackingcodeinterview.chapter8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EightQueens_8_12 {
    boolean[] dia;
    boolean[] antiDia;
    boolean cols[];
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        cols = new boolean[n];
        dia = new boolean[2 * n - 1];
        antiDia = new boolean[2 * n - 1];
        putQueen(0, n, new int[n][n]);
        return res;
    }

    private void putQueen(int row, int n, int[][] board) {
        if (row == n) {
            res.add(generateBoard(board));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (cols[i] || dia[i + row] || antiDia[row - i + n - 1]) continue;
            cols[i] = true;
            dia[i + row] = true;
            antiDia[row - i + n - 1] = true;
            board[row][i] = 1;
            putQueen(row + 1, n, board);
            board[row][i] = 0;
            cols[i] = false;
            dia[i + row] = false;
            antiDia[row - i + n - 1] = false;
        }
    }

    private List<String> generateBoard(int[][] board) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String str = "";
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    str += "Q";
                } else {
                    str += ".";
                }
            }
            list.add(str);
        }
        return list;
    }
}
