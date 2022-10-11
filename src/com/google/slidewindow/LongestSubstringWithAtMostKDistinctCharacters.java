package com.google.slidewindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) return 0;
        int start = 0;
        int i = 0;
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        while (i < s.length()) {
            if (map.size() < k || map.keySet().contains(s.charAt(i))) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
                i++;
            } else {
                res = Math.max(i - start, res);
                while (map.size() == k) {
                    map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                    if (map.get(s.charAt(start)) == 0) {
                        map.remove(s.charAt(start));
                    }
                    start++;
                }
            }
        }
        res = Math.max(res, s.length() - start);
        return res;
    }
}
