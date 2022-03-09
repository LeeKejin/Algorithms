package com.google.tree.dfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class BraceExpansionII {
    public List<String> braceExpansionII(String expression) {
        Queue<String> queue = new LinkedList<>();
        queue.add(expression);
        Set<String> res = new HashSet<>();
        while (!queue.isEmpty()) {
            String str = queue.poll();
            if (str.indexOf("{") == -1) {
                res.add(str);
                continue;
            }
            int left = 0;
            int i = 0;
            int right = 0;
            while (str.charAt(i) != '}') {
                i++;
            }
            right = i;
            while (str.charAt(i) != '{') {
                i--;
            }
            left = i;
            String before = str.substring(0, left);
            String after = str.substring(right + 1, str.length());
            String middle[] = str.substring(left + 1, right).split(",");
            for (String m : middle) {
                queue.add(before + m + after);
            }
        }
        return res.stream().sorted().collect(Collectors.toList());
    }
}
