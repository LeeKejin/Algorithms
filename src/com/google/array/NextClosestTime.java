package com.google.array;

import java.util.*;

public class NextClosestTime {
    List<String> combo = new ArrayList<>();

    public String nextClosestTime(String time) {
        Set<Integer> list = new HashSet<>();
        for (char ch : time.toCharArray()) {
            if (Character.isDigit(ch)) {
                list.add(Integer.parseInt(String.valueOf(ch)));
            }
        }

        dfs(list, "");

        Collections.sort(combo, (a, b) -> {
            String prevA = a.substring(0, 2);
            String afterA = a.substring(2);

            String prevB = b.substring(0, 2);
            String afterB = b.substring(2);

            if (prevA.equals(prevB)) {
                return afterA.compareTo(afterB);
            }
            return prevA.compareTo(prevB);
        });
        String last = combo.get(combo.size() - 1);
        String[] strs = time.split(":");
        String prev = strs[0];
        String after = strs[1];
        if (last.equals(prev + after)) {
            String first = combo.get(0);
            return first.substring(0, 2) + ":" + first.substring(2);
        }

        int index = combo.indexOf(prev + after);
        String res = combo.get(index + 1);
        return res.substring(0, 2) + ":" + res.substring(2);
    }

    private void dfs(Set<Integer> list, String s) {
        if (s.length() == 4) {
            String prev = s.substring(0, 2);
            String after = s.substring(2);
            if (Integer.parseInt(prev) < 24 && Integer.parseInt(after) < 60) {
                combo.add(s);
            }
            return;
        }
        for (int val : list) {
            dfs(list, s + val);
        }
    }

}
