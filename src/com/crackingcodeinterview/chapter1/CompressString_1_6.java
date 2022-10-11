package com.crackingcodeinterview.chapter1;

public class CompressString_1_6 {
    public String compressString(String S) {
        if (S.length() <= 1) return S;
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char ch = S.charAt(0);
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == ch) {
                count++;
            } else {
                sb.append(ch);
                sb.append(count);
                ch = S.charAt(i);
                count = 1;
            }
        }
        sb.append(ch);
        sb.append(count);
        if (sb.length() < S.length()) return sb.toString();
        return S;
    }
}
