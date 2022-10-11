package com.google.tree.dfs.longestconsecutive;

import com.google.tree.TreeNode;

/*
250. Count Univalue Subtrees
508. Most Frequent Subtree Sum
543. Diameter of Binary Tree
1245. Tree Diameter
687. Longest Univalue Path
124. Binary Tree Maximum Path Sum
Max Path Sum in a Grid
298. Binary Tree Longest Consecutive Sequence
549. Binary Tree Longest Consecutive Sequence II
 */
public class BinaryTreeLongestConsecutiveSequence {
    int max = 0;

    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (root.left != null && root.left.val != root.val + 1) {
            left = 0;
        }
        if (root.right != null && root.right.val != root.val + 1) {
            right = 0;
        }
        max = Math.max(Math.max(left, right) + 1, max);
        return Math.max(left, right) + 1;
    }
}
