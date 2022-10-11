package com.crackingcodeinterview.chapter10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupAnagrams_10_2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String k = String.valueOf(chs);
            map.putIfAbsent(k, new ArrayList<>());
            map.get(k).add(str);
        }
        List<List<String>> res = new ArrayList<>();
        for (String k : map.keySet()) {
            map.get(k).sort((a, b) -> a.compareTo(b));
            res.add(map.get(k));
        }
        return res;
    }
}
