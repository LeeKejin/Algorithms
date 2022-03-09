package com.amazon.interview.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leet797 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(0, graph, new LinkedList<Integer>());
        return ans;
    }

    private void dfs(int start, int[][] graph, LinkedList<Integer> list) {
        list.add(start);
        if (start == graph.length - 1) {

            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < graph[start].length; i++) {
            dfs(graph[start][i], graph, list);
            list.removeLast();
        }
    }
}
