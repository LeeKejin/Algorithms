package com.google.backtrace;

import java.util.Arrays;

/**
 * Time Complexity: What basically we are doing is, we are traversing the entire nums array for each subset
 * (once we are done with one subset, for the next subset we are starting again with index 0).
 * So for each subset, we are choosing the suitable elements from the nums array
 * (basically iterate over nums and for each element either use it or drop it,
 * which is O(2^n) operation where n is the size of nums). We are doing the same for each subset.
 * Total subsets are k. So Time Complexity becomes O(k*(2^n)).
 */
public class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length < k) return false;
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        int val = sum / k;
        return dfs(nums, k, val, 0, new boolean[nums.length], 0);
    }

    private boolean dfs(int[] nums, int k, int sum, int cur, boolean[] visited, int start) {
        if (k == 1) return true;
        if (cur > sum) return false;
        if (cur == sum) {
            return dfs(nums, k - 1, sum, 0, visited, 0);
        }

        for (int i = start; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            if (dfs(nums, k, sum, cur + nums[i], visited, i + 1)) return true;
            visited[i] = false;
        }
        return false;
    }
}

