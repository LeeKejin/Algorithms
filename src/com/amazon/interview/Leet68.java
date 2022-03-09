package com.amazon.interview;

import java.util.ArrayList;
import java.util.List;

//https://happygirlzt.com/code/68.html
public class Leet68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int index = 0;
        int n = words.length;
        while (index < words.length) {
            int last = index + 1;
            int totalChars = words[index].length();//MUST add the first(index!!!!) word, cause the index th word may not need a " "!!!!!!
            while (last < n) {
                if (totalChars + 1 + words[last].length() > maxWidth) break;
                totalChars += 1 + words[last].length();
                last++;
            }
            StringBuilder sb = new StringBuilder();
            int gap = last - index - 1;
            if (gap == 0 || last == n) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i != last - 1) sb.append(' ');
                }
                while (sb.length() < maxWidth) {
                    sb.append(' ');
                }
            } else {
                int spaces = (maxWidth - totalChars) / gap;
                int rest = (maxWidth - totalChars) % gap;
                for (int i = index; i < last - 1; i++) {
                    sb.append(words[i]);
                    sb.append(" ");
                    for (int j = 0; j < spaces + ((i - index) < rest ? 1 : 0); j++) {
                        sb.append(" ");
                    }
                }
                sb.append(words[last - 1]);
            }
            res.add(sb.toString());
            index = last;
        }
        return res;
    }
}
