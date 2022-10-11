package com.google.array;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        String r1 = process(s);
        String r2 = process(t);
        return r1.equals(r2);
    }

    private String process(String s) {
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                sb1.append(s.charAt(i));
            } else {
                if (i == 0) continue;
                if (sb1.length() == 0) continue;
                sb1.deleteCharAt(sb1.length() - 1);
            }
        }
        return sb1.toString();
    }
    /*
    Space O(1)
    Time O(N)
     */
    /*
     public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1, back;
        while (true) {
            back = 0;
            while (i >= 0 && (back > 0 || S.charAt(i) == '#')) {
                back += S.charAt(i) == '#' ? 1 : -1;
                i--;
            }
            back = 0;
            while (j >= 0 && (back > 0 || T.charAt(j) == '#')) {   //without T.charAt(j) == '#', test case like "ab#c", "ad#c" will fail, as b and d are not deleted
                back += T.charAt(j) == '#' ? 1 : -1;
                j--;
            }
            if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
                i--;
                j--;
            } else {
                break;
            }
        }
        return i == -1 && j == -1;
    }
     */
}
