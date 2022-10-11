package com.google.tree.dfs.longestconsecutive;

import com.google.tree.TreeNode;

public class LongestUnivaluePath {
    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }

    int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int l = 0;
        int r = 0;
        if (root.left != null && root.val == root.left.val) {
            l = left;
        }
        if (root.right != null && root.val == root.right.val) {
            r = right;
        }
        max = Math.max(l + r, max);
        return Math.max(l, r) + 1;
    }
}
