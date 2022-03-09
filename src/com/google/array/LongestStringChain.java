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
        Arrays.sort(words, ((a, b) -> (a.length() - b.length())));
        Map<String, Integer> map = new HashMap<>();
        map.put(words[0], 1);
        int res = 1;
        for (int i = 1; i < words.length; i++) {

            for (int j = 0; j < words[i].length(); j++) {
                StringBuilder sb = new StringBuilder(words[i]);
                sb = sb.deleteCharAt(j);
                int v = map.getOrDefault(sb.toString(), 0);
                int n = Math.max(map.getOrDefault(words[i], 1), v + 1);
                map.put(words[i], n);
            }
            res = Math.max(res, map.get(words[i]));
        }
        return res;
    }
}
