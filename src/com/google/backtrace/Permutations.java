package com.google.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * N*(N-1)*(N-2).... = N!
 */
public class Permutations {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, -1, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int start, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {

            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            dfs(nums, i, list);
            list.remove(list.size() - 1);
        }
    }
}
