package com.google.slidewindow;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int start = 0;
        int i = 0;
        int res = 0;
        int count[] = new int[26];
        int maxCount = 0;
        while (i < s.length()) {
            maxCount = Math.max(maxCount, ++count[s.charAt(i) - 'A']);
            while (i + 1 - start - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            res = Math.max(res, i + 1 - start);
            i++;
        }
        return Math.max(res, s.length() - start);
    }
}
