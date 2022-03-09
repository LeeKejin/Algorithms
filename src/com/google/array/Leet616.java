package com.google.array;

public class Leet616 {
    public String addBoldTag(String s, String[] words) {
        boolean bold[] = new boolean[s.length()];

        for (String word : words) {
            int start = 0;
            while (true) {
                int i = s.indexOf(word, start);
                if (i < 0) break;
                for (int j = i; j < i + word.length(); j++) {
                    bold[j] = true;
                }
                start++;
            }

        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < bold.length) {
            if (!bold[i]) {
                sb.append(s.charAt(i));
                i++;
            } else {
                sb.append("<b>");
                int j = i;
                while (j < bold.length && bold[j]) {
                    j++;
                }
                sb.append(s.substring(i, j));
                sb.append("</b>");
                i = j;
            }
        }
        return sb.toString();

    }

}
