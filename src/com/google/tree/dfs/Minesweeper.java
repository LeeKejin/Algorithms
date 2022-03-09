package com.google.tree.dfs;

public class Minesweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        if (board[x][y] != 'E') return board;
        dfs(board, x, y);
        return board;
    }

    int[][] dirs = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'E') return;
        board[x][y] = '0';
        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length) continue;
            if (board[newX][newY] == 'M') {
                board[x][y]++;
            }
        }
        if (board[x][y] != '0') return;
        board[x][y] = 'B';
        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            dfs(board, newX, newY);
        }
    }
}
