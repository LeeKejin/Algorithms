package com.google.backtrace;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueen {
    Set<Integer> rows = new HashSet<>();
    Set<Integer> cols = new HashSet<>();
    Set<Integer> dia = new HashSet<>();
    Set<Integer> antiDia = new HashSet<>();
    List<List<String>> list = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(0, n, board);

        return list;
    }

    private void dfs(int cur, int n, char[][] board) {
        if (cur == n) {
            List<String> innerList = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                String str = String.valueOf(board[i]);

                innerList.add(str);
            }

            list.add(innerList);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!rows.contains(cur) && !cols.contains(i) && !dia.contains(cur - i) && !antiDia.contains(cur + i)) {
                rows.add(cur);
                cols.add(i);
                dia.add(cur - i);
                antiDia.add(cur + i);

                board[cur][i] = 'Q';
                dfs(cur + 1, n, board);
                board[cur][i] = '.';

                rows.remove(cur);
                cols.remove(i);
                dia.remove(cur - i);
                antiDia.remove(cur + i);
            }
        }
    }
}
