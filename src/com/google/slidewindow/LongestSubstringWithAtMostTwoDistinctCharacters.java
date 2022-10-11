package com.google.slidewindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int k = 2;
        int start = 0;
        int res = 0;
        while (i < s.length()) {
            if (map.getOrDefault(s.charAt(i), 0) == 0) k--;
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            while (k < 0) {
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);

                if (map.get(s.charAt(start)) == 0) k++;
                start++;
            }
            res = Math.max(res, i - start + 1);
            i++;
        }
        return res;
    }
}
