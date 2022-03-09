package com.algorithms.tree.backtrace.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet40 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, new ArrayList<>(), target, 0);
        return res;
    }

    private void dfs(int[] candidates, int i, List<Integer> lists, int target, int sum) {
        if (sum > target) return;
        if (sum == target) {
            res.add(new ArrayList<>(lists));
        }

        for (int j = i; j < candidates.length; j++) {
            if (j > i && candidates[j] == candidates[j - 1]) continue;
            lists.add(candidates[j]);
            dfs(candidates, j + 1, lists, target, sum + candidates[j]);
            lists.remove(lists.size() - 1);
        }
    }


    public static void main(String[] args) {
        Leet40 test = new Leet40();
        test.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }
}
