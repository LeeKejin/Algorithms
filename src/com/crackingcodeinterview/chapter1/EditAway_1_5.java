package com.crackingcodeinterview.chapter1;

public class EditAway_1_5 {
    public boolean oneEditAway(String first, String second) {
        if (Math.abs(first.length() - second.length()) >= 2) return false;
        if (Math.abs(first.length() - second.length()) == 1) {
            if (first.length() > second.length()) {
                if (first.contains(second)) return true;
                return check(first, second);
            } else {
                if (second.contains(first)) return true;
                return check(second, first);
            }

        }
        boolean flag = false;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) == second.charAt(i)) continue;
            if (flag) return false;
            flag = true;
        }
        return true;
    }

    private boolean check(String first, String second) {
        int i = 0;
        int j = 0;
        while (i < first.length()) {
            if (first.charAt(i) == second.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == second.length();
    }
}
