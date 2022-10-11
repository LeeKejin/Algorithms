package com.algorithms.array.slidewindow;

import java.util.HashSet;
import java.util.Set;

public class Leet3 {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int start = 0;
        int[] freq = new int[256];
        int res = 0;
        while (i < s.length()) {
            if (freq[s.charAt(i)] == 0) {
                freq[s.charAt(i)]++;
                i++;
            } else {
                freq[s.charAt(start)]--;
                start++;
            }
            res = Math.max(res, i - start);
        }
        return res;
    }

    public int lengthOfLongestSubstring1(String s) {
        int start = 0;
        int res = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(start));

                start++;
            }
            set.add(s.charAt(i));

            res = Math.max(res, i - start + 1);
        }
        return res;

    }
}
