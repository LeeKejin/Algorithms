package com.google.tree;

public class PathSum {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return res;
    }

    private int dfs(TreeNode node, int sum) {
        if (node == null) return 0;
        int left = Math.max(dfs(node.left, node.val), 0);
        int right = Math.max(dfs(node.right, node.val), 0);
        res = Math.max(res, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
