package com.amazon.interview.trie;

import java.util.ArrayList;
import java.util.List;

public class Leet212 {
    /*
    When search word with trie, dfs with NODE!!!!!
    时间复杂度：O(m * n * 3^{l-1})，其中 m 是二维网格的高度，n 是二维网格的宽度，l 是最长单词的长度。我们仍需要遍历 m×n 个单元格，
    每个单元格在最坏情况下仍需要遍历 4 *3^{l-1} 条路径。

     */
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;

    }

    List<String> res = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        if (words.length == 0 || board.length == 0) return new ArrayList<>();
        for (String word : words) {
            TrieNode node = root;

            for (char ch : word.toCharArray()) {
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
            }
            node.word = word;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.children[board[i][j] - 'a'] != null) {
                    dfs(board, i, j, root);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
                board[i][j] == '#' || node.children[board[i][j] - 'a'] == null) {//this condition must be this node.children[board[i][j] - 'a'] == null!!!
            return;
        }

        if (node.children[board[i][j] - 'a'].word != null) {
            String val = node.children[board[i][j] - 'a'].word;
            res.add(val);
            node.children[board[i][j] - 'a'].word = null;
        }

        char ch = board[i][j];
        board[i][j] = '#';
        dfs(board, i - 1, j, node.children[ch - 'a']);
        dfs(board, i + 1, j, node.children[ch - 'a']);
        dfs(board, i, j - 1, node.children[ch - 'a']);
        dfs(board, i, j + 1, node.children[ch - 'a']);
        board[i][j] = ch;
    }
}
