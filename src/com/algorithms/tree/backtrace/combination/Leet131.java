package com.algorithms.tree.backtrace.combination;

import java.util.ArrayList;
import java.util.List;

public class Leet131 {
    List<List<String>> results = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) return results;
        dfs(s, new ArrayList<>(), 0);
        return results;
    }

    private void dfs(String s, ArrayList<String> list, int start) {
        if (s.length() == start) {
            results.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                list.add(s.substring(start, i + 1));
                dfs(s, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int i) {
        while (start < i) {
            if (s.charAt(start) == s.charAt(i)) {
                start++;
                i--;
            } else {
                return false;
            }
        }
        return true;
    }
}
