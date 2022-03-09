package com.algorithms.tree.backtrace.combination;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
 https://leetcode.com/problems/subsets/  ->  Leet78
 https://leetcode.com/problems/subsets-ii/ -> Leet90
 https://leetcode.com/problems/permutations/ -> Leet46
 https://leetcode.com/problems/permutations-ii/ -> Leet47
 https://leetcode.com/problems/combination-sum-ii/ -> Leet40
 https://leetcode.com/problems/palindrome-partitioning/ -> Leet131
 */
public class Leet39 {
    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        back(candidates, target, 0, new ArrayList<>());
        return results;
    }

    private void back(int[] candidates, int target, int start, ArrayList<Integer> list) {
        if (target == 0) {
            results.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) continue;
            list.add(candidates[i]);
            back(candidates, target - candidates[i], i, list);
            list.remove(list.size() - 1);
        }
    }
}
