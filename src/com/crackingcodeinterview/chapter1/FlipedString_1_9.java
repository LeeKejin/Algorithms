package com.crackingcodeinterview.chapter1;

public class FlipedString_1_9 {
    public boolean isFlipedString1(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int i = 0;
        String s = "";
        for (i = 0; i < s2.length(); i++) {
            s = s2.substring(i);
            if (s1.startsWith(s)) break;
        }
        String str = s + s2.substring(0, i);
        return str.equals(s1);
    }

    public boolean isFlipedString2(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        return (s1 + s1).contains(s2);
    }
}
