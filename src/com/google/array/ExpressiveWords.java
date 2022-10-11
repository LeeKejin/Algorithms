package com.google.array;

//hello
public class ExpressiveWords {
    public int expressiveWords(String s, String[] words) {
        int count = 0;
        for (String word : words) {
            if (check(s, word)) {
                System.out.println(word);
                count++;
            }
        }
        return count;
    }

    private boolean check(String s, String word) {
        if (word.length() > s.length()) return false;
        int j = 0;
        int i = 0;
        while (i < word.length()) {
            char ch = word.charAt(i);
            int wN = repeatCount(word, ch, i);
            int sN = repeatCount(s, ch, j);


            if (sN < 3 && sN != wN) return false;
            if (sN >= 3 && sN < wN) return false;
            i = i + wN;
            j = j + sN;
        }

        return j == s.length();
    }

    private int repeatCount(String word, char ch, int start) {
        int count = 0;
        for (int i = start; i < word.length(); i++) {
            if (ch == word.charAt(i)) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
