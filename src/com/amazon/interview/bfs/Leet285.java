package com.amazon.interview.bfs;

import com.algorithms.binary.search.tree.leetcode.TreeNode;

public class Leet285 {
    TreeNode prev = null;
    TreeNode res = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inorder(root, p);
        return res;
    }

    public void inorder(TreeNode root, TreeNode p) {
        if (root == null) return;
        inorderSuccessor(root.left, p);
        if (p == prev) {
            res = root;
        }

        prev = root;
        inorderSuccessor(root.right, p);
    }
}
