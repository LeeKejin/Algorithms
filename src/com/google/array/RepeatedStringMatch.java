package com.google.array;

public class RepeatedStringMatch {
    public int repeatedStringMatch(String a, String b) {

        if (a.contains(b)) return 1;
        if (b.indexOf(a) == -1) {
            String s = a + a;
            if (s.contains(b)) return 2;
            return -1;
        }
        int start = b.indexOf(a);
        String prev = b.substring(0, start);
        if (!a.endsWith(prev)) return -1;
        int count = prev.equals("") ? 0 : 1;
        String s = b.substring(start);
        while (s.indexOf(a) != -1) {
            s = s.substring(a.length());
            count++;
        }
        if (s.length() == 0) return count;
        if (a.startsWith(s)) return count + 1;
        return -1;
    }
}
