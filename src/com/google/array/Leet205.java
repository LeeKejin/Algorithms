package com.google.array;

import java.util.HashMap;
import java.util.Map;

public class Leet205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);
            if (mapS.containsKey(chS)) {
                if (mapS.get(chS) != chT) return false;
            }
            if (mapT.containsKey(chT)) {
                if (mapT.get(chT) != chS) return false;
            }
            mapS.put(chS, chT);
            mapT.put(chT, chS);
        }
        return true;
    }
}

