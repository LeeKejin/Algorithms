package com.google.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet336 {
    class Trie {
        Trie[] children = new Trie[26];
        List<Integer> palindromePrefixRemaining = new ArrayList<>();
        int isEnd = -1;
    }

    Trie root = new Trie();

    public List<List<Integer>> palindromePairs(String[] words) {

        if (words.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();


        for (int i = 0; i < words.length; i++) {
            Trie node = root;
            for (int j = words[i].length() - 1; j >= 0; j--) {
                int index = words[i].charAt(j) - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                if (isPrefixPalindrome(words[i], 0, j)) {
                    node.palindromePrefixRemaining = new ArrayList<>(node.palindromePrefixRemaining);
                    node.palindromePrefixRemaining.add(i); //palindromePrefixRemaining has to be set on the current node, like sll, ll is palindrome,
                    // but at s's node palindromePrefixRemaining would be NOT NULL, because if there is another word s, after reaching s, it cannot go
                    // further to check what's the palindromePrefixRemaining on l, so it can only check the palindromePrefixRemaining on currenct node s.
                }
                node = node.children[index];
            }
            node.isEnd = i;
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Trie node = root;
            for (int j = 0; j < word.length(); j++) {
                //case 3 word: banana ---> b, word banana is longer than b, so trie branch is finished but banana doesn't
                //so need to check if the remaing string in WORD which is anana is a palindrome
                if (node.isEnd != -1 && isPrefixPalindrome(word, j, word.length() - 1)) {
                    res.add(Arrays.asList(i, node.isEnd));
                }
                int num = word.charAt(j) - 'a';
                node = node.children[num];
                if (node == null) break;
            }
            if (node == null) continue;
            //case 1 abcd dcba
            if (node.isEnd != -1 && node.isEnd != i) {
                res.add(Arrays.asList(i, node.isEnd));
            }

            //case 2 word: cat --->  olotac  word cat is shorter than olotac, when cat finished, but trie branch is still continuing, so need to check if
            // remaining string in trie is a palindrome
            for (int other : node.palindromePrefixRemaining) {
                res.add(Arrays.asList(i, other));
            }
        }
        return res;
    }


    private boolean isPrefixPalindrome(String word, int start, int end) {

        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

}
