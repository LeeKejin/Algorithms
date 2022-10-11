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
public class BinaryTreeLongestConsecutiveSequenceII {
    int max = 0;

    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return max;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int dec = 1; //count node initialize as 1, count path initialize as 0
        int inc = 1;
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        if (root.left != null) {
            if (root.left.val + 1 == root.val) {
                dec = left[0] + 1;
            }
            if (root.left.val - 1 == root.val) {
                inc = left[1] + 1;
            }
        }
        if (root.right != null) {
            if (root.right.val + 1 == root.val) {
                dec = Math.max(dec, right[0] + 1);
            }
            if (root.right.val - 1 == root.val) {
                inc = Math.max(inc, right[1] + 1);
            }
        }
        max = Math.max(max, dec + inc - 1);
        return new int[]{dec, inc};
    }
}
