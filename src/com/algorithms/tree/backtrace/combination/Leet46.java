package com.algorithms.tree.backtrace.combination;

import java.util.ArrayList;
import java.util.List;

public class Leet46 {
    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, new ArrayList<Integer>());
        return results;
    }

    private void dfs(int[] nums, ArrayList<Integer> list) {
        if (list.size() == nums.length) {
            results.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            dfs(nums, list);
            list.remove(list.size() - 1);
        }
    }
}
