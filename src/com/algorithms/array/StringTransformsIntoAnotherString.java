package com.algorithms.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class StringTransformsIntoAnotherString {
    public boolean canConvert(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        if (str1.equals(str2)) return true;
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            char s1 = str1.charAt(i);
            char s2 = str2.charAt(i);
            if (map.containsKey(s1) && map.get(s1) != s2) return false;
            map.put(s1, s2);
        }
        //In one conversion you can convert all occurrences of one character in str1 to any other lowercase English character.
//A tmp char is required to replace other chars

        return new HashSet<Character>(map.values()).size() < 26;
    }

}
