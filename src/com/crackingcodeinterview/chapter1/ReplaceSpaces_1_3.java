package com.crackingcodeinterview.chapter1;

public class ReplaceSpaces_1_3 {
    public String replaceSpaces(String S, int length) {
        int index = S.length() - 1;
        char[] chs = S.toCharArray();
        for (int i = length - 1; i >= 0; i--) {
            if (S.charAt(i) == ' ') {
                chs[index--] = '0';
                chs[index--] = '2';
                chs[index--] = '%';
            } else {
                chs[index--] = S.charAt(i);
            }
        }
        return String.valueOf(chs);
    }
}
