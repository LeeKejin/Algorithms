package com.google.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidWordAbbr {
    Map<String, Set<String>> map = new HashMap<>();

    public ValidWordAbbr(String[] dictionary) {
        for (String word : dictionary) {
            if (word.length() <= 2) {
                map.putIfAbsent(word, new HashSet<>());
                map.get(word).add(word);
            } else {
                String val = generate(word);
                map.putIfAbsent(val, new HashSet<>());
                map.get(val).add(word);
            }
        }
    }

    private String generate(String word) {
        int num = word.length() - 2;
        StringBuilder sb = new StringBuilder();
        sb.append(word.charAt(0));
        sb.append(num);
        sb.append(word.charAt(word.length() - 1));
        return sb.toString();
    }

    public boolean isUnique(String word) {
        if (map.containsKey(word)) return true;

        if (word.length() <= 2) {
            return true;
        } else {
            String val = generate(word);
            if (!map.containsKey(val)) return true;
            Set<String> set = map.get(val);
            if (set.size() == 1 && set.contains(word)) return true;
            return false;
        }
    }
}
