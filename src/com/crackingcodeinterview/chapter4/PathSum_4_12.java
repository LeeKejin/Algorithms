package com.crackingcodeinterview.chapter4;

import com.google.tree.TreeNode;
import com.google.tree.utility.TreeUtil;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class PathSum_4_12 {
    int count = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        check(root, map, sum, 0);
        return count;
    }

    private void check(TreeNode root, Map<Integer, Integer> map, int sum, int cur) {
        if (root == null) return;
        cur += root.val;
        count += map.getOrDefault(cur - sum, 0);
        map.put(cur, 1);
        check(root.left, map, sum, cur);
        check(root.right, map, sum, cur);
        map.put(cur, map.get(cur) - 1);
    }

    private void find(TreeNode root, int sum) {
        if (root == null) return;
        if (sum - root.val == 0) {
            count++;
        }
        find(root.left, sum - root.val);
        find(root.right, sum - root.val);
    }

    public static void main(String[] args) {
//        TreeNode root = TreeUtil.deserialize("[5,4,8,11,null,13,4,7,2,null,null,5,1]");
        TreeNode root = TreeUtil.deserialize("[1,2]");
        PathSum_4_12 test = new PathSum_4_12();
        test.pathSum(root, 2);
    }

    int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) return -1;
        int step = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] p = queue.poll();
                if (p[0] == m - 1 && p[1] == n - 1) return step;
                for (int[] dir : dirs) {
                    int x = p[0] + dir[0];
                    int y = p[1] + dir[1];
                    if (withinRange(x, y, m, n)) {
                        queue.add(new int[]{x, y});
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private boolean withinRange(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
