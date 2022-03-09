package com.google.array;

public class Leet2018_failer {
    public boolean placeWordInCrossword(char[][] board, String word) {
        if (word.length() == 0) return true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == ' ') {
                    if (find(board, word, i, j, 0)) {
                        return true;
                    }
                }
                if (word.startsWith(String.valueOf(board[i][j]))) {
                    if (find(board, word, i, j, 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean find(char[][] board, String word, int i, int j, int index) {
        int len = word.length() - index;
        if (checkUp(i, j, board, word)) {
            boolean b = true;

            for (int k = i; k < board.length; k++) {
                if (board[k][j] != ' ' && (k - i < word.length() && board[k][j] != word.charAt(k - i))) {
                    b = false;
                    break;
                }
            }
            if (b) {
                if (i + len == board.length || (i + word.length() < board.length && board[i + word.length()][j] == '#')) {
                    return true;

                }
            }

        }

        if (checkRight(i, j, board, word)) {
            boolean b = true;
            for (int k = j; k < board[0].length; k++) {
                if (board[i][k] != ' ' && (k - i < word.length() && board[i][k] != word.charAt(k - j))) {
                    b = false;
                    break;
                }
            }
            if (b) {
                if (j + word.length() == board[0].length || (j + word.length() < board[0].length && board[i][j + word.length()] == '#')) return true;
            }
        }

        String reverse = new StringBuilder(word).reverse().toString();
        if (checkUp(i, j, board, reverse)) {
            boolean b = true;

            for (int k = i; k < board.length; k++) {
                if (board[k][j] != ' ' && (k - i < word.length() && board[k][j] != reverse.charAt(k - i))) {
                    b = false;
                    break;
                }
            }
            if (b) {
                if (i + len == board.length || (i + word.length() < board.length && board[i + word.length()][j] == '#')) {
                    return true;

                }
            }

        }

        if (checkRight(i, j, board, reverse)) {
            boolean b = true;
            for (int k = j; k < board[0].length; k++) {
                if (board[i][k] != ' ' && (k - i < word.length() && board[i][k] != reverse.charAt(k - j))) {
                    b = false;
                    break;
                }
            }
            if (b) {
                if (j + word.length() == board[0].length || (j + word.length() < board[0].length && board[i][j + word.length()] == '#')) return true;
            }
        }

        return false;

    }

    private boolean checkRight(int i, int j, char[][] board, String word) {
        boolean before = false;
        if (j == 0) {
            before = true;
        } else {
            before = board[i][j - 1] == '#';
        }

        boolean after = j + word.length() <= board[0].length;
        return before && after;
    }

    private boolean checkUp(int i, int j, char[][] board, String word) {
        boolean before = false;
        if (i == 0) {
            before = true;
        } else {
            before = board[i - 1][j] == '#';
        }

        boolean after = i + word.length() <= board.length;
        return before && after;
    }

}

