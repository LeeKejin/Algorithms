package com.google.array;

import java.util.Collections;
import java.util.List;

public class LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        Collections.sort(dictionary);
        for (String word : dictionary) {
            int i = 0;
            int j = 0;
            if (word.length() <= res.length()) continue;
            while (i < s.length() && j < word.length()) {
                if (s.charAt(i) == word.charAt(j)) {
                    i++;
                    j++;
                } else {
                    i++;
                }
            }
            if (j == word.length()) {
                res = word;
            }
        }
        return res;
    }

}
