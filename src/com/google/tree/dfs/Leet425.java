package com.google.tree.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet425 {
    public List<List<String>> wordSquares(String[] words) {
        List<String> firstWords = new ArrayList<>();
        int n = 5;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            n = Math.min(n, word.length());
            if (ifFirst(word, words)) {
                firstWords.add(word);
            }
        }

        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        Map<String, List<String>> prefixMap = new HashMap<>();
        for (String word : firstWords) {
            list.clear();
            list.add(word);
            dfs(list, words, res, n, 1, prefixMap);
        }
        return res;
    }

    private void dfs(List<String> list, String[] words, List<List<String>> res, int n, int row, Map<String, List<String>> prefixMap) {
        if (list.size() == n) {
            res.add(new ArrayList<>(list));
            return;
        }

        List<String> prefixes = findPrefix(words, list, row, prefixMap);

        for (String word : prefixes) {
            list.add(word);
            dfs(list, words, res, n, row + 1, prefixMap);
            list.remove(list.size() - 1);
        }
    }

    private List<String> findPrefix(String[] words, List<String> list, int row, Map<String, List<String>> prefixMap) {
        StringBuilder sb = new StringBuilder();

        for (String str : list) {
            sb.append(str.charAt(row));
        }
        String prefix = sb.toString();
        if (prefixMap.containsKey(prefix)) return prefixMap.get(prefix);
        prefixMap.put(prefix, new ArrayList<>());
        for (String word : words) {
            if (word.startsWith(prefix)) {
                prefixMap.get(prefix).add(word);
            }
        }
        return prefixMap.get(prefix);
    }

    private boolean ifFirst(String word, String[] words) {
        for (char ch : word.toCharArray()) {
            boolean flag = false;
            for (int i = 0; i < words.length; i++) {
                if (words[i].startsWith(String.valueOf(ch))) {
                    flag = true;
                    break;
                }
            }
            if (!flag) return false;
        }
        return true;
    }
}
