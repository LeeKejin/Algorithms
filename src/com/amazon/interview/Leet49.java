package com.amazon.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String orderedStr = String.valueOf(chars);
            if (map.containsKey(orderedStr)) {
                map.get(orderedStr).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(orderedStr, list);
            }
        }

        for (List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }

    public List<List<String>> groupAnagrams1(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chs = new char[26];
            for (char ch : str.toCharArray()) {
                chs[ch - 'a']++;
            }
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 26; i++) {
                while (chs[i] > 0) {
                    sb.append((char) ('a' + i));
                    chs[i]--;
                }
            }
            map.putIfAbsent(sb.toString(), new ArrayList<>());
            map.get(sb.toString()).add(str);
        }
        List<List<String>> res = new ArrayList<>();
        res.addAll(map.values());

        return res;
    }

    int getHash(String str) {
        char[] chs = new char[26];
        for (char ch : str.toCharArray()) {
            chs[ch - 'a']++;
        }
        return Arrays.hashCode(chs);
    }

    //Best!
    public List<List<String>> groupAnagrams2(String[] strs) {

        Map<Integer, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int hash = getHash(str);
            map.putIfAbsent(hash, new ArrayList<>());
            map.get(hash).add(str);
        }
        List<List<String>> res = new ArrayList<>();
        res.addAll(map.values());

        return res;
    }
}
