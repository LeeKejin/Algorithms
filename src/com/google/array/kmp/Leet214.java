package com.google.array.kmp;

public class Leet214 {
    public String shortestPalindrome(String s) {
        String kmpstr = s + "#" + new StringBuilder(s).reverse().toString();
        return new StringBuilder(s.substring(kmp(kmpstr))).reverse().toString() + s;
    }

    int kmp(String s) {
        int next[] = new int[s.length() + 1];
        for (int i = 1, j = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i + 1] = j;
        }
        return next[s.length()];
    }
}
