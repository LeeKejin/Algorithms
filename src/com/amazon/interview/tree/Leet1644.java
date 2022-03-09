package com.amazon.interview.tree;

import com.algorithms.graph.TreeNode;

public class Leet1644 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        boolean findP = find(root, p);
        boolean findQ = find(root, q);
        if (findP && findQ) {
            return lowestAncestor(root, p, q);
        }
        return null;
    }

    public TreeNode lowestAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        boolean isLeft = find(root.left, p, q);
        boolean isRight = find(root.right, p, q);
        if (!isLeft && !isRight) return root;
        if (isLeft) return lowestAncestor(root.left, p, q);
        return lowestAncestor(root.right, p, q);
    }

    private boolean find(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return false;
        boolean isPExists = find(node, p);
        boolean isQExists = find(node, q);
        return isPExists && isQExists;
    }

    private boolean find(TreeNode node, TreeNode p) {
        if (node == null) return false;
        if (node.val == p.val) return true;
        return find(node.left, p) || find(node.right, p);
    }
}
