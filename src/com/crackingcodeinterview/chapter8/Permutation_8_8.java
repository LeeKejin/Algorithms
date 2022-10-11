package com.crackingcodeinterview.chapter8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Permutation_8_8 {
    List<String> list = new ArrayList<>();

    public String[] permutation(String s) {
        char[] chs = s.toCharArray();
        Arrays.sort(chs);
        s = String.valueOf(chs);
        boolean[] visited = new boolean[s.length()];
        dfs(s, visited, "");

        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void dfs(String s, boolean[] visited, String str) {
        if (s.length() == str.length()) {
            list.add(str);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (visited[i]) continue;
            if (i > 0 && s.charAt(i) == s.charAt(i - 1) && !visited[i - 1]) continue;
            visited[i] = true;
            dfs(s, visited, str + s.charAt(i));
            visited[i] = false;
        }
    }
}
