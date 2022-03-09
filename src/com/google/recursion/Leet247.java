package com.google.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet247 {
    public List<String> findStrobogrammatic(int n) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');

        return generate(map, n, n);
    }

    private List<String> generate(Map<Character, Character> map, int curSize, int n) {
        if (curSize == 0) return new ArrayList<>(Arrays.asList(""));
        if (curSize == 1) return new ArrayList<>(Arrays.asList("0", "1", "8"));
        List<String> prevList = generate(map, curSize - 2, n);
        List<String> list = new ArrayList<>();
        for (String prev : prevList) {
            for (char ch : map.keySet()) {
                if (ch == '0' && curSize == n) { //'0' cannot be the first digit during last recursion
                    continue;
                }
                String s = ch + prev + map.get(ch);
                list.add(s);
            }
        }
        return list;
    }
}
