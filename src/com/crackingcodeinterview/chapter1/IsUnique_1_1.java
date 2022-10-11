package com.crackingcodeinterview.chapter1;

import java.util.HashSet;
import java.util.Set;

public class IsUnique_1_1 {
    public boolean isUnique(String astr) {
        Set<Character> set = new HashSet<>();
        for (char ch : astr.toCharArray()) {
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }
}
