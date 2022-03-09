package com.google.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class AutocompleteSystem {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        boolean isEnd = false;
    }

    TrieNode root = new TrieNode();
    String prefix = "";

    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) {
            String str = sentences[i];
            int time = times[i];
            addSentence(str, time);
        }
    }

    private void addSentence(String str, int time) {
        TrieNode node = root;
        for (char ch : str.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode());
            }
            node = node.children.get(ch);
            node.count.put(str, node.count.getOrDefault(str, 0) + time);
        }
        node.isEnd = true;
    }

    public List<String> input(char c) {
        if (c == '#') {
            addSentence(prefix, 1);
            prefix = "";
            return new ArrayList<>();
        }
        TrieNode node = root;
        prefix += c;
        for (char ch : prefix.toCharArray()) {
            if (!node.children.containsKey(ch)) return new ArrayList<>();
            node = node.children.get(ch);
        }
        PriorityQueue<Map.Entry<String, Integer>> queue =
                new PriorityQueue<>((a, b) -> (a.getValue() == b.getValue()
                        ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue()));
        queue.addAll(node.count.entrySet());
        int k = 3;
        List<String> list = new ArrayList<>();
        while (!queue.isEmpty() && k > 0) {
            list.add(queue.poll().getKey());
            k--;
        }
        return list;
    }

}
