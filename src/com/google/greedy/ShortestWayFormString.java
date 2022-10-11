package com.google.greedy;

import java.util.HashSet;
import java.util.Set;

public class ShortestWayFormString {
    public int shortestWay(String source, String target) {
        int index = 0;
        int count = 0;
        int i = 0;
        Set<Character> set = new HashSet<>();
        for (int k = 0; k < source.length(); k++) {
            set.add(source.charAt(k));
        }
        while (i < target.length()) {
            if (!set.contains(target.charAt(i))) return -1;
            while (index < source.length() && i < target.length()) {
                if (source.charAt(index) == target.charAt(i)) {
                    i++;
                    index++;

                } else {
                    index++;
                }
            }
            if (index == source.length() || (target.length() == i)) {
                index = 0;
                count++;
            }

        }
        return count;
    }

    public int shortestWayWithOutSet(String source, String target) {
        int index = 0;
        int count = 0;
        int i = 0;

        while (i < target.length()) {
            int orgI = i;
            while (index < source.length() && i < target.length()) {
                if (source.charAt(index) == target.charAt(i)) {
                    i++;
                    index++;
                } else {
                    index++;
                }
            }
            if (orgI == i) return -1;
            if (index == source.length() || i == target.length()) {
                count++;
                index = 0;
            }
        }
        return count;
    }
}
