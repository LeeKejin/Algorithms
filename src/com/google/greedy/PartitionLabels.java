package com.google.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, i);
        }
        int cur = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            cur = Math.max(map.get(ch), cur);
            if (i == cur) {
                list.add(i + 1);
            }
        }
        for (int i = list.size() - 1; i > 0; i--) {
            int val = list.get(i) - list.get(i - 1);
            list.set(i, val);
        }
        return list;
    }
}
