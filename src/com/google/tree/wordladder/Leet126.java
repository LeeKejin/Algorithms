package com.google.tree.wordladder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Leet126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        set.addAll(wordList);
        set.remove(beginWord);
        if (!set.contains(endWord)) return new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        List<List<String>> res = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for (String word : wordList) {
            char[] chs = word.toCharArray();

            for (int i = 0; i < word.length(); i++) {
                char ch = chs[i];
                chs[i] = '*';
                String t = String.valueOf(chs);
                map.putIfAbsent(t, new ArrayList<>());
                map.get(t).add(word);
                chs[i] = ch;
            }
        }
        Map<String, List<String>> adjList = new HashMap<>();
        Set<String> dup = new HashSet<>();
        dup.add(beginWord);
        while (!queue.isEmpty()) {
            List<String> visited = new ArrayList<>();
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String word = queue.poll();

                if (word.equals(endWord)) continue;

                char chs[] = word.toCharArray();
                adjList.putIfAbsent(word, new ArrayList<>());
                for (int i = 0; i < word.length(); i++) {
                    char ch = chs[i];
                    chs[i] = '*';
                    String t = String.valueOf(chs);
                    for (String w : map.getOrDefault(t, new ArrayList<>())) {

                        if (!set.contains(w) || w.equals(word)) continue;
                        visited.add(w);
                        adjList.get(word).add(w);
                        if (!dup.contains(w)) { //cannopt add same word to q multiple times
                            dup.add(w);
                            queue.add(w);
                        }
                    }
                    chs[i] = ch;
                }
            }
            for (String v : visited) { //set needs to be cleaned up after retrieve the whole layer, if it's cleaned up right after add to q, the word on
                // the same layer may miss the answer. dog->cog, but log cannot, as cog has been deleted when processing dog
                set.remove(v);
            }
        }
        List<String> l = new ArrayList<>();
        l.add(beginWord);
        find(adjList, res, l, beginWord, endWord);
        return res;
    }

    private void find(Map<String, List<String>> adjList, List<List<String>> res, List<String> list, String source, String dest) {
        if (source.equals(dest)) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (String w : adjList.get(source)) {
            list.add(w);
            find(adjList, res, list, w, dest);
            list.remove(list.size() - 1);
        }
    }
}
