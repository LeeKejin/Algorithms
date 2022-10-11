package com.google.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {
    /*
    sorting takes O(N(logN)) create sb and loop each char take O(L^2)  ---> O(N *(logN + L^2))
    N is words number, L is word length
     */
    public int longestStrChain(String[] words) {
        if (words.length == 0) return 0;
        Arrays.sort(words, (a, b) -> (a.length() == b.length() ? a.compareTo(b) : a.length() - b.length()));
        Map<String, Integer> map = new HashMap<>();
        map.put(words[0], 1);
        int res = 1;
        for (int i = 1; i < words.length; i++) {
            map.put(words[i], 1);
            for (int j = 0; j < words[i].length(); j++) {
                StringBuilder sb = new StringBuilder(words[i]);
                sb = sb.deleteCharAt(j);
                if (map.containsKey(sb.toString()) && map.get(sb.toString()) + 1 > map.get(words[i])) {
                    map.put(words[i], map.get(sb.toString()) + 1);
                }
            }
            res = Math.max(res, map.get(words[i]));
        }
        return res;
    }
}
