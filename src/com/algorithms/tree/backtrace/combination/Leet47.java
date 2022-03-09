package com.algorithms.tree.backtrace.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet47 {
    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) return results;
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(nums, new ArrayList<Integer>(), used);
        return results;
    }

    private void dfs(int[] nums, ArrayList<Integer> list, boolean[] used) {
        if (nums.length == list.size()) {
            results.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            list.add(nums[i]);
            dfs(nums, list, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
