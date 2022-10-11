package com.crackingcodeinterview.chapter8;

import java.util.ArrayList;
import java.util.List;

public class Subsets_8_4 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>());
        dfs(0, nums, new ArrayList<>());

        return res;
    }

    private void dfs(int start, int[] nums, ArrayList<Integer> list) {
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            res.add(new ArrayList<>(list));
            dfs(i + 1, nums, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets_8_4 test = new Subsets_8_4();
        int x = 1 << 1;
        int min = 3;
        int max = 11;
        int ans = 0;

        for (int i = 0; min != 0; i++) {
            if ((min & 1) == 1) {
                ans += max << i;
            }
            min >>= 1;
        }
        System.out.println(ans);
    }
}
