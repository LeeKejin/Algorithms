package com.google.array.strobogrammatic;

public class IsStrobogrammatic {
    public boolean isStrobogrammatic(String num) {
        char[] chs = num.toCharArray();
        int i = 0;
        int j = num.length() - 1;
        while (i <= j) {
            char f = num.charAt(i);
            char b = num.charAt(j);
            if ((f == '1' && b == '1') || (f == '0' && b == '0') || (f == '8' && b == '8')) {
                i++;
                j--;
            } else if (((f == '6' && b == '9') || (f == '9' && b == '6'))) {
                i++;
                j--;
            } else {
                return false;
            }

        }
        return true;
    }
}
