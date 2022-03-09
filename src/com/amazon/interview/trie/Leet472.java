package com.amazon.interview.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet472 {
    class Trie {
        Trie[] children = new Trie[26];
        boolean isEnd = false;
    }

    Trie root = new Trie();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (w1, w2) -> w1.length() - w2.length());
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (word.length() == 0) continue;
            if (dfs(word, 0)) {
                list.add(word);
            } else {
                insert(word);
            }
        }
        return list;
    }

    private boolean dfs(String word, int start) {
        if (word.length() == start) return true;
        Trie trie = root;
        for (int i = start; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (trie.children[ch - 'a'] == null) return false;
            trie = trie.children[ch - 'a'];
            if (trie.isEnd) {
                if (dfs(word, i + 1)) return true;
            }

        }
        return false;
    }

    private void insert(String word) {
        Trie trie = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (trie.children[ch - 'a'] == null) {
                trie.children[ch - 'a'] = new Trie();
            }

            trie = trie.children[ch - 'a'];
        }
        trie.isEnd = true;
    }
}
