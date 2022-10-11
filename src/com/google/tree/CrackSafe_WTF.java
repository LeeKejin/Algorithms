package com.google.tree;

import java.util.HashSet;
import java.util.Set;

/*
O(k^n)
 */
public class CrackSafe_WTF {
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int total = (int) Math.pow(k, n);
        for (int i = 0; i < n; i++) {
            sb.append('0');
        }
        Set<String> visited = new HashSet<>();
        visited.add(sb.toString());
        dfs(sb, total, visited, n, k);
        return sb.toString();
    }

    private boolean dfs(StringBuilder sb, int total, Set<String> visited, int n, int k) {
        if (visited.size() == total) return true;
        String prev = sb.substring(sb.length() - n + 1);
        for (int i = 0; i < k; i++) {
            String next = prev + i;
            if (!visited.contains(next)) {
                visited.add(next);
                if (dfs(sb.append(i), total, visited, n, k)) return true;
                visited.remove(next);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return false;
    }

/*

    public String crackSafe(int n, int k) {
        int total = (int) Math.pow(k, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("0");
        }
        Set<String> visited = new HashSet<>();
        visited.add(sb.toString());
        dfs(sb, visited, total, n, k);
        return sb.toString();
    }

    private boolean dfs(StringBuilder sb, Set<String> visited, int total, int n, int k) {
        if (visited.size() == total) return true;
        String prev = sb.substring(sb.length() - n + 1);
        //根据欧拉环  一直从最大的数开始循环就不用 visited.remove(next); 和 sb.deleteCharAt(sb.length()-1);
        //also the boolean can be changed to void
        for (int i = k-1; i >= 0; i--) {
            String next = prev + i;
            if (visited.contains(next)) continue;
            visited.add(next);
            if (dfs(sb.append(i), visited, total, n, k)) return true;
            // visited.remove(next);
            // sb.deleteCharAt(sb.length()-1);
        }
        return false;
    }

    //LIKE THIS
    private void dfs(StringBuilder sb, Set<String> visited, int total, int n, int k) {
        if (visited.size() == total) return ;
        String prev = sb.substring(sb.length() - n + 1);
        for (int i = k-1; i >= 0; i--) {
            String next = prev + i;
            if (visited.contains(next)) continue;
            visited.add(next);
            dfs(sb.append(i), visited, total, n, k);
            // visited.remove(next);
            // sb.deleteCharAt(sb.length()-1);
        }

    }

 */
}
