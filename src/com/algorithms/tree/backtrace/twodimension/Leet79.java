package com.algorithms.tree.backtrace.twodimension;

public class Leet79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, board, visited, word, 0)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, char[][] board, boolean[][] visited, String word, int cur) {
        if (cur == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || visited[i][j] || word.charAt(cur) != board[i][j]) {//word.charAt(cur) != board[i][j] is IMPORTANT
            return false;
        }
        visited[i][j] = true;
        if (dfs(i - 1, j, board, visited, word, cur + 1)
                || dfs(i + 1, j, board, visited, word, cur + 1)
                || dfs(i, j - 1, board, visited, word, cur + 1)
                || dfs(i, j + 1, board, visited, word, cur + 1)) return true;
        visited[i][j] = false;
        return false;
    }

}
