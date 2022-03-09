package com.google.trie;

import java.util.ArrayList;
import java.util.List;

/*
O(NK^2 +QK)
where N is the number of words, K is the maximum length of a word, and Q is the number of queries.

 */
public class PrefixAndSuffixSearch {
    class Trie {
        Trie[] children = new Trie[26];
        List<Integer> prefixIndexes = new ArrayList<>();
        boolean isEnd = false;
    }

    Trie root = new Trie();
    String[] words;

    public PrefixAndSuffixSearch(String[] words) {
        this.words = words;
        for (int i = 0; i < words.length; i++) {
            Trie node = root;
            String word = words[i];
            for (char ch : word.toCharArray()) {
                int num = ch - 'a';
                if (node.children[num] == null) {
                    node.children[num] = new Trie();
                }
                node = node.children[num];
                node.prefixIndexes.add(i);
            }
            node.isEnd = true;
        }

    }

    public int f(String prefix, String suffix) {
        Trie node = root;
        for (char ch : prefix.toCharArray()) {
            if (node.children[ch - 'a'] == null) return -1;
            node = node.children[ch - 'a'];
        }
        List<Integer> indexes = node.prefixIndexes;
        for (int i = indexes.size() - 1; i >= 0; i--) {
            String word = words[indexes.get(i)];
            if (word.endsWith(suffix)) return indexes.get(i);
        }

        return -1;
    }
}
