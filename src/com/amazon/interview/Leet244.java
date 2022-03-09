package com.amazon.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet244 {
    Map<String, List<Integer>> map = new HashMap<>();

    public Leet244(String[] wordsDict) {
        for (int i = 0; i < wordsDict.length; i++) {
            map.putIfAbsent(wordsDict[i], new ArrayList<>());
            map.get(wordsDict[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> word1List = map.get(word1);
        List<Integer> word2List = map.get(word2);
        return merge(word1List, word2List);
    }

    private int merge(List<Integer> word1List, List<Integer> word2List) {
        int i = 0;
        int j = 0;
        int dist = Integer.MAX_VALUE;

        while (i < word1List.size() && j < word2List.size()) {
            dist = Math.min(dist, Math.abs(word1List.get(i) - word2List.get(j)));
            if (word1List.get(i) < word2List.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return dist;
    }
}
