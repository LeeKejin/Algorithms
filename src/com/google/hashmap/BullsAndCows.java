package com.google.hashmap;

import java.util.HashMap;
import java.util.Map;

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char sec : secret.toCharArray()) {
            freqMap.put(sec, freqMap.getOrDefault(sec, 0) + 1);
        }
        int bu = 0;
        int co = 0;
        for (int i = 0; i < secret.length(); i++) {
            char sec = secret.charAt(i);
            char gus = guess.charAt(i);
            if (sec == gus) {
                freqMap.put(gus, freqMap.get(gus) - 1);
                bu++;
                if (freqMap.get(gus) < 0) {
                    co--;
                }
            } else if (sec != gus && freqMap.containsKey(gus) && freqMap.get(gus) - 1 >= 0) {
                freqMap.put(gus, freqMap.get(gus) - 1);
                co++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(bu).append('A').append(co).append('B');

        return sb.toString();
    }

    public String getHint1(String secret, String guess) {
        int As = 0, Bs = 0;
        int[] counts = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if (s == g) {
                As++;
            } else {
                ++counts[s - '0'];
                --counts[g - '0'];
                if (counts[s - '0'] <= 0) {
                    Bs++;
                }
                if (counts[g - '0'] >= 0) {
                    Bs++;
                }
            }
        }
        return As + "A" + Bs + "B";
    }

}
