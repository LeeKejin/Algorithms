package com.google.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leet681 {
    Set<String> combinations = new HashSet<>();

    public String nextClosestTime(String time) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < time.length(); i++) {
            if (Character.isDigit(time.charAt(i))) {
                list.add(Integer.parseInt(String.valueOf(time.charAt(i))));
            }
        }
        int firstTime = Integer.parseInt(time.split(":")[0]);
        int secondTime = Integer.parseInt(time.split(":")[1]);
        dfs(list, "", time.split(":")[0] + time.split(":")[1]);
        combinations.add(time.split(":")[0] + time.split(":")[1]);
        if (combinations.size() == 0) return time;

        List<String> sortedList = new ArrayList<>();
        sortedList.addAll(combinations);
        sortedList.sort((a, b) -> {
            int firstA = Integer.parseInt(a.substring(0, 2));
            int secondA = Integer.parseInt(a.substring(2, 4));

            int firstB = Integer.parseInt(b.substring(0, 2));
            int secondB = Integer.parseInt(b.substring(2, 4));

            if (firstA == firstB) return secondA - secondB;
            return firstA - firstB;
        });
        String last = sortedList.get(sortedList.size() - 1);
        int first = Integer.parseInt(last.substring(0, 2));
        int second = Integer.parseInt(last.substring(2, 4));


        if (firstTime >= first && secondTime >= second) {
            String s1 = sortedList.get(0).substring(0, 2);
            String s2 = sortedList.get(0).substring(2, 4);
            return s1 + ":" + s2;
        }
        int start = sortedList.indexOf(time.split(":")[0] + time.split(":")[1]);
        String s = sortedList.get(start + 1);
        String s1 = s.substring(0, 2);
        String s2 = s.substring(2, 4);
        return s1 + ":" + s2;
    }

    private void dfs(List<Integer> list, String str, String time) {
        if (str.length() == 4) {
            String prev = str.substring(0, 2);
            String last = str.substring(2, 4);
            int first = Integer.parseInt(prev);
            int second = Integer.parseInt(last);
            if (first < 24 && second < 60) combinations.add(str);
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            dfs(list, str + list.get(i), time);
        }
    }
}
