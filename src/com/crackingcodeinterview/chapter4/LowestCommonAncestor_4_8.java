package com.crackingcodeinterview.chapter4;

import com.google.tree.TreeNode;

public class LowestCommonAncestor_4_8 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == q || root == p) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) return root;
        if (left == null) return lowestCommonAncestor(root.right, p, q);
        return lowestCommonAncestor(root.left, p, q);

    }
}
