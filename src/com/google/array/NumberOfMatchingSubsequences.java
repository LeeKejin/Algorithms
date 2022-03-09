package com.google.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfMatchingSubsequences {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, List<Integer>> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.putIfAbsent(ch, new ArrayList<>());
            map.get(ch).add(i);
        }
        for (String word : words) {
            int cur = -2;
            for (int i = 0; i < word.length(); i++, cur++) {
                char ch = word.charAt(i);
                if (!map.containsKey(ch)) break;
                cur = binarySearch(map.get(ch), cur);
                if (cur == -1) break;
                if (i == word.length() - 1) {
                    res++;
                }
            }

        }
        return res;
    }

    int binarySearch(List<Integer> list, int idx) {
        int l = 0;
        int r = list.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) == idx) return list.get(mid);
            if (list.get(mid) < idx) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (l == list.size()) return -1;
        return list.get(l);
    }
}
