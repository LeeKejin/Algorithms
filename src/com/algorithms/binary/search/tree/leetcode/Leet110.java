package com.algorithms.binary.search.tree.leetcode;

public class Leet110 {
    boolean res = true;

    public boolean isBalanced(com.algorithms.graph.TreeNode root) {
        if (root == null) return true;
        check(root, 0);
        return res;
    }

    private int check(com.algorithms.graph.TreeNode node, int level) {
        if (node == null) return level;
        level++;
        int left = check(node.left, level);
        int right = check(node.right, level);

        if (Math.abs(left - right) >= 1) {
            res = false;
        }
        return Math.max(left, right);
    }

    public boolean isBalanced1(TreeNode root) {
        return depth(root) != -1;
    }

    int depth(TreeNode node) {
        if (node == null) return 0;
        int left = depth(node.left);
        if (left == -1) return -1;
        int right = depth(node.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

    }
}
