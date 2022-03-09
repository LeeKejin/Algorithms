package com.amazon.interview;

public class Leet28 {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle.length() > haystack.length()) return -1;
        if (needle.equals("")) return 0;

        for (int i = 0; i < haystack.length(); i++) {
            if (needle.length() > 0 && haystack.charAt(i) == needle.charAt(0)) {
                int k = i;
                k++;
                int j;
                for (j = 1; j < needle.length(); j++, k++) {
                    if (k >= haystack.length()) return -1;
                    if (haystack.charAt(k) != needle.charAt(j)) {
                        break;
                    }
                }
                if (j == needle.length()) {
                    return i;
                }
            }

        }
        return haystack.equals(needle) ? 0 : -1;
    }

    public int strStrKMP(String haystack, String needle) {
        if (haystack == null || needle.length() > haystack.length()) return -1;
        if (needle.equals("")) return 0;
        int[] next = generateNext(needle);
        int j = -1;
        for (int i = 0; i < haystack.length(); i++) {
            while (j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) {
                j = next[j];
            }
            if (haystack.charAt(i) == needle.charAt(j + 1)) {
                j++;
            }
            if (j == needle.length() - 1) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

    private int[] generateNext(String needle) {
        int[] next = new int[needle.length()];
        next[0] = -1;
        int j = -1;
        for (int i = 1; i < needle.length(); i++) {
            while (j >= 0 && needle.charAt(i) != needle.charAt(j + 1)) {
                j = next[j];
            }
            if (needle.charAt(i) == needle.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
