package com.google.array;

import java.util.HashMap;
import java.util.Map;

public class Leet833 {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indices.length; i++) {
            map.put(indices[i], i);
        }
        int i = 0;
        while (i < s.length()) {
            if (!map.containsKey(i)) {
                sb.append(s.charAt(i));
                i++;
                continue;
            }
            int index = map.get(i);
            String source = sources[index];
            if (source.equals(s.substring(i, i + source.length()))) {
                sb.append(targets[index]);
                i += source.length();
            } else {
                sb.append(s.charAt(i));
                i++;
            }

        }
        return sb.toString();

    }
}
