package com.crackingcodeinterview.chapter1;

import java.util.HashMap;
import java.util.Map;

public class PermutePalindrome_1_4 {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        boolean flag = false;
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : map.keySet()) {
            if (map.get(ch) % 2 == 0) continue;
            if (flag) return false;
            flag = true;
        }
        return true;
    }
}
