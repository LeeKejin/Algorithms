package com.google.array;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < words.length) {
            String word = words[i];
            if (sb.length() + word.length() + 1 <= maxWidth) {
                sb.append(word + " ");
                i++;
            } else if (sb.length() + word.length() == maxWidth) {
                sb.append(word);
                i++;
            } else {
                String str = sb.toString();
                if (str.charAt(str.length() - 1) == ' ') str = str.substring(0, str.length() - 1);
                list.add(str);
                sb = new StringBuilder();
            }
        }
        list.add(sb.toString());
        List<String> res = new ArrayList<>();

        for (int m = 0; m < list.size(); m++) {
            String str = list.get(m);
            if (str.length() == maxWidth) {
                res.add(str);
                continue;
            }
            int extra = maxWidth - str.length();
            String[] w = str.split(" ");
            int size = w.length - 1;
            StringBuilder stringBuilder = new StringBuilder();

            if (m == list.size() - 1 && size != 0) {
                stringBuilder.append(str);
                while (stringBuilder.length() < maxWidth) {
                    stringBuilder.append(" ");
                }
                res.add(stringBuilder.toString());
                continue;
            }
            if (size == 0) {
                stringBuilder.append(str);
                for (int j = 0; j < extra; j++) {
                    stringBuilder.append(" ");
                }
                res.add(stringBuilder.toString());
                continue;
            }

            int avg = extra / size;
            int left = extra % size;


            for (int j = 0; j < w.length - 1; j++) {
                stringBuilder.append(w[j] + ' ');
                for (int k = 0; k < avg; k++) {
                    stringBuilder.append(' ');
                }
                if (j < left) stringBuilder.append(' ');//前left个元素每个后面多加一个space，平均分配left
            }
            stringBuilder.append(w[size]);
            res.add(stringBuilder.toString());
        }
        return res;

    }
}
