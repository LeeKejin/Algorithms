package com.crackingcodeinterview.chapter8;

import java.util.ArrayList;
import java.util.List;

public class Permutation_8_7 {
    List<String> list = new ArrayList<>();

    public String[] permutation(String s) {

        for (int i = 0; i < s.length(); i++) {
            boolean[] visited = new boolean[s.length()];
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(i));
            visited[i] = true;
            dfs(i, sb, s, visited);
        }
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void dfs(int index, StringBuilder stringBuilder, String s, boolean[] visited) {
        if (stringBuilder.length() == s.length()) {
            list.add(stringBuilder.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (visited[i]) continue;
            stringBuilder.append(s.charAt(i));
            visited[i] = true;
            dfs(i + 1, stringBuilder, s, visited);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            visited[i] = false;

        }
    }

    public static void main(String[] args) {
        Permutation_8_7 test = new Permutation_8_7();
        test.permutation("qwe");
    }
}
