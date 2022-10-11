package com.google.array.strobogrammatic;

public class StrobogrammaticNumberIII {
    private static final char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    int res = 0;

    public int strobogrammaticInRange(String low, String high) {
        for (int i = low.length(); i <= high.length(); i++) {
            dfs(low, high, new char[i], 0, i - 1);
        }

        return res;
    }

    private void dfs(String low, String high, char[] chs, int left, int right) {
        if (left > right) {
            String s = String.valueOf(chs);
            if (s.length() == low.length() && s.compareTo(low) < 0 || s.length() == high.length() && s.compareTo(high) > 0) {
                return;
            }
            res++;
            return;
        }

        for (char p[] : pairs) {
            chs[left] = p[0];
            chs[right] = p[1];
            if (chs.length != 1 && chs[0] == '0') continue;
            if (left == right && p[0] != p[1]) continue;
            dfs(low, high, chs, left + 1, right - 1);
        }
    }
}
