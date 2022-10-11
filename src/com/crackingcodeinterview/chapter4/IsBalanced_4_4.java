package com.crackingcodeinterview.chapter4;

import com.google.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class IsBalanced_4_4 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    int getDepth(TreeNode node) {
        if (node == null) return -1;
        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }

    public boolean isBalancedBottomUp(TreeNode root) {
        return height(root) >= 0;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}


