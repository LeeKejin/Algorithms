package com.crackingcodeinterview.chapter8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CountEval_8_14 {
    Integer memo[][][];

    public int countEval(String s, int result) {
        int n = s.length();
        memo = new Integer[n][n][2];
        return dfs(0, n - 1, s, result);
    }

    private int dfs(int l, int r, String s, int result) {
        if (l > r) return 0;
        if (l == r) {
            if (s.charAt(l) - '0' == result) return 1;
            return 0;
        }
        if (memo[l][r][result] != null) return memo[l][r][result];
        int ans = 0;
        for (int i = l; i <= r; i++) {
            char c = s.charAt(i);
            if (result == 0) {
                if (c == '&')
                    ans += dfs(l, i - 1, s, 0) * dfs(i + 1, r, s, 0) + dfs(l, i - 1, s, 0) * dfs(i + 1, r, s, 1) + dfs(l, i - 1, s, 1) * dfs(i + 1, r, s, 0); //00、01、10
                if (c == '|') ans += dfs(l, i - 1, s, 0) * dfs(i + 1, r, s, 0); //00
                if (c == '^')
                    ans += dfs(l, i - 1, s, 0) * dfs(i + 1, r, s, 0) + dfs(l, i - 1, s, 1) * dfs(i + 1, r, s, 1); //00、11
            } else {
                if (c == '&') ans += dfs(l, i - 1, s, 1) * dfs(i + 1, r, s, 1); //11
                if (c == '|')
                    ans += dfs(l, i - 1, s, 0) * dfs(i + 1, r, s, 1) + dfs(l, i - 1, s, 1) * dfs(i + 1, r, s, 0) + dfs(l, i - 1, s, 1) * dfs(i + 1, r, s, 1); //01、10、11
                if (c == '^')
                    ans += dfs(l, i - 1, s, 0) * dfs(i + 1, r, s, 1) + dfs(l, i - 1, s, 1) * dfs(i + 1, r, s, 0); //10、01
            }

        }
        memo[l][r][result] = ans;
        return memo[l][r][result];
    }

    public boolean hasAllCodes(String s, int k) {
        double n = Math.pow(2, k);
        Set<String> set = new HashSet<>();
        int start = 0;
        for (int end = k; end <= s.length(); end++, start++) {
            String str = s.substring(start, end);
            set.add(str);
        }
        return set.size() == (int) n;
    }

    public static void main(String[] args) {
        CountEval_8_14 test = new CountEval_8_14();
        test.hasAllCodes("00110110",
                2);
    }

}
