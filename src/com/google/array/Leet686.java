package com.google.array;

import java.util.HashSet;
import java.util.Set;

public class Leet686 {
    public int repeatedStringMatch1(String a, String b) {
        Set<Character> set = new HashSet<>();
        for (char ch : a.toCharArray()) {
            set.add(ch);
        }
        for (char ch : b.toCharArray()) {
            if (!set.contains(ch)) return -1;
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        for (int i = 0; i <= 2; i++) {
            if (sb.toString().contains(b)) return count;
            sb.append(a);
            count++;
        }

        return -1;
    }

    public int repeatedStringMatch(String a, String b) {
        Set<Character> set = new HashSet<>();
        for (char ch : a.toCharArray()) {
            set.add(ch);
        }
        for (char ch : b.toCharArray()) {
            if (!set.contains(ch)) return -1;
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }
        if (sb.length() == b.length()) {
            if (sb.toString().equals(b)) return count;
            sb.append(a);
            count++;
        }
        String s = sb.toString();
        String temp = s;
        for (int i = 0; i < sb.length(); i++) {
            if (temp.startsWith(b)) return count;
            if (i + 1 < sb.length()) temp = s.substring(i + 1);
        }
        s += a;
        temp = s;
        for (int i = 0; i < sb.length(); i++) {
            if (temp.startsWith(b)) return count;
            if (i + 1 < sb.length()) temp = s.substring(i + 1);
        }
        if (temp.startsWith(b)) return count + 1;
        return -1;
    }
}
