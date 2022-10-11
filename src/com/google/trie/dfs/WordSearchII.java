package com.google.trie.dfs;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    /**
     * Time complexity: O(M(4*3^(L-1)), where M is the number of cells in the board and L is the maximum length of words.
     * It is tricky is calculate the exact number of steps that a backtracking algorithm would perform.
     * We provide a upper bound of steps for the worst scenario for this problem.
     * The algorithm loops over all the cells in the board, therefore we have M as a factor in the complexity formula.
     * It then boils down to the maximum number of steps we would need for each starting cell (i.e.4*3^(L-1)).
     * <p>
     * Assume the maximum length of word is L, starting from a cell, initially we would have at most 4 directions to explore.
     * Assume each direction is valid (i.e. worst case), during the following exploration, we have at most 3 neighbor cells
     * (excluding the cell where we come from) to explore. As a result, we would traverse at most 4*3^(L-1)
     * cells during the backtracking exploration.
     * <p>
     * <p>
     * One might wonder what the worst case scenario looks like. Well, here is an example. Imagine, each of the cells in the board contains the letter a,
     * and the word dictionary contains a single word ['aaaa']. Voila. This is one of the worst scenarios that the algorithm would encounter.
     * [a,a,a,a,a]
     * [a,a,a,a,a]
     * [a,a,a,a,a]
     * [a,a,a,a,a]
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
