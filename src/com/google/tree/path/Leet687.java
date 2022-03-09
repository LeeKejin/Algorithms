package com.google.tree.path;

import com.algorithms.graph.TreeNode;

public class Leet687 {
    int res = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        dfs(root, root.val);
        return res;
    }

    private int dfs(TreeNode node, int val) {
        if (node == null) return 0;
        int left = dfs(node.left, node.val);
        int right = dfs(node.right, node.val);
        res = Math.max(res, left + right);

        if (node.val == val) {
            return Math.max(left, right) + 1;
        } else {
            return 0;
        }
    }
}
