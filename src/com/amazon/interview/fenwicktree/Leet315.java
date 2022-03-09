package com.amazon.interview.fenwicktree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.youtube.com/watch?v=2SVLYsq5W8M
//https://zxi.mytechroad.com/blog/algorithms/array/leetcode-315-count-of-smaller-numbers-after-self/
public class Leet315 {
    class FenwickTree {
        int[] sums;

        public FenwickTree(int n) {
            sums = new int[n + 1];
        }

        public int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += sums[i];
                i -= lowbit(i);
            }
            return sum;
        }

        public void update(int i, int val) {
            while (i < sums.length) {
                sums[i] += val;
                i += lowbit(i);
            }
        }

        private int lowbit(int i) {
            return i & (-i);
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int sort[] = new int[nums.length];
        sort = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sort);

        Map<Integer, Integer> ranks = new HashMap<>();
        int rank = 0;
        for (int i = 0; i < sort.length; i++) {
            if (i == 0 || sort[i] != sort[i - 1]) {
                ranks.put(sort[i], ++rank);
            }
        }
        List<Integer> list = new ArrayList<>();
        FenwickTree tree = new FenwickTree(nums.length);
        for (int i = nums.length - 1; i >= 0; i--) {
            list.add(tree.query(ranks.get(nums[i]) - 1));
            tree.update(ranks.get(nums[i]), 1);
        }
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        Leet315 test = new Leet315();
        test.countSmaller(new int[]{5, 2, 6, 1});
    }
}
