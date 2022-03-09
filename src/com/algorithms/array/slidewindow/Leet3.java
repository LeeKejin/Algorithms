package com.algorithms.array.slidewindow;

import java.util.HashSet;
import java.util.Set;

public class Leet3 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = -1;
        int res = 0;
        int[] freq = new int[256];
        char[] chars = s.toCharArray();
        while (left < s.length()) {
            if (right + 1 < s.length() && freq[chars[right + 1]] == 0) {
                right++;
                freq[chars[right]]++;
            } else {
                freq[chars[left]]--;
                left++;
            }
            res = Math.max(res, right - left + 1);
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
