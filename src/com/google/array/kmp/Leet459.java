package com.google.array.kmp;

public class Leet459 {
    public boolean repeatedSubstringPattern(String s) {
        int[] next = build(s);
        if (next[s.length()] == 0) return false;
        return s.length() % (s.length() - next[s.length()]) == 0;
    }


    private int[] build(String s) {
        int[] next = new int[s.length() + 1];
        for (int i = 1, j = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i + 1] = j;
        }
        return next;
    }
}
