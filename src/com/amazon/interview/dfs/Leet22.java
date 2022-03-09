package com.amazon.interview.dfs;

import java.util.ArrayList;
import java.util.List;

public class Leet22 {
    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<>();
        dfs(0, 0, n, "");
        return list;
    }

    private void dfs(int left, int right, int n, String res) {
        if (left == right && left == n) {
            list.add(res);
            return;
        }
        if (left < n) {
            dfs(left + 1, right, n, res + "(");
        }
        if (right < left) {
            dfs(left, right + 1, n, res + ")");
        }
    }

}
