package com.algorithms.tree.backtrace.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet90 {
    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, new ArrayList<Integer>(), 0);
        return results;
    }

    private void dfs(int[] nums, ArrayList<Integer> list, int start) {
        results.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            dfs(nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
