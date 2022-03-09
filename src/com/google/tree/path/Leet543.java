package com.google.tree.path;

import com.google.tree.TreeNode;

public class Leet543 {
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        cal(root);
        return res;
    }

    private int cal(TreeNode node) {

        if (node == null) return 0;
        int left = cal(node.left);
        int right = cal(node.right);
        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;

    }
}
