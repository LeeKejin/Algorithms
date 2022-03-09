package com.google.array.kmp;

import java.util.ArrayList;
import java.util.List;

public class KMP {
    /*
      int[] next = test.build("ABCDABD");
       List<Integer> list = test.match("ABC ABCDAB ABCDABCDABDE", "ABCDABD", next);

        int[] next = test.build("AAA");
        List<Integer> list = test.match("AAAAA", "AAA", next);
        O(n)
     */
    int[] build(String s) {
        int next[] = new int[s.length() + 1];
        int i = 1;
        int j = 0;
        for (i = 1; i < s.length(); i++) {
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

    List<Integer> match(String s, String p, int[] next) {
        List<Integer> list = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && s.charAt(i) != p.charAt(j)) {
                j = next[j];
            }
            if (s.charAt(i) == p.charAt(j)) {
                j++;
            }
            if (j == m) {
                list.add(i - m + 1);
                j = next[j];
            }
        }
        return list;
    }
}
