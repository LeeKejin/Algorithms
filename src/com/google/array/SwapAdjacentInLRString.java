package com.google.array;

public class SwapAdjacentInLRString {
    public boolean canTransform(String start, String end) {
        if (start.length() != end.length() ||
                (!start.replaceAll("X", "").equals(end.replaceAll("X", "")))) return false;
        int i = 0;
        int j = 0;
        while (i < start.length() && j < end.length()) {
            while (i < start.length() && start.charAt(i) == 'X') {
                i++;
            }
            while (j < end.length() && end.charAt(j) == 'X') {
                j++;
            }
            if (i == start.length() && j == end.length()) return true;
            if (i == start.length() || j == end.length()) return false;
            if (start.charAt(i) != end.charAt(j)) return false;
            if (start.charAt(i) == 'L' && i < j) return false;
            if (start.charAt(i) == 'R' && i > j) return false;
            i++;
            j++;
        }
        return true;
    }
}
