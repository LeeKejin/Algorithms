package com.google.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GuessTheWord {
    public void findSecretWord(String[] wordlist, Master master) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(wordlist.length);
            String word = wordlist[index];
            int k = master.guess(word);
            if (k == 6) return;
            List<String> list = new ArrayList<>();
            for (String w : wordlist) {
                if (w.equals(word)) continue;
                if (match(w, word) == k) {
                    list.add(w);
                }
            }
            wordlist = list.toArray(new String[list.size()]);
        }
    }

    int match(String s, String t) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (s.charAt(i) == t.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    class Master {
        int guess(String w) {
            return 0;
        }
    }
}
