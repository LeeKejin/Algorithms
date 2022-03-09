package com.google.array.kmp;

public class Leet28 {
    public int strStr(String haystack, String needle) {
        if (haystack.equals(needle) || needle.length() == 0) return 0;
        if (haystack.length() == 0) return -1;
        int[] next = build(needle);
        int res = match(haystack, needle, next);
        return res;
    }

    private int match(String haystack, String needle, int[] next) {
        for (int i = 0, j = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

    private int[] build(String needle) {
        int next[] = new int[needle.length() + 1];
        for (int i = 1, j = 0; i < needle.length(); i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            next[i + 1] = j;
        }
        return next;
    }
}
