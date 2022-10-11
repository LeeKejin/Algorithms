package com.google.tree.dfs;

import com.google.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class DirectionsFromBinaryTreeNodeToAnother {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        if (root == null) return "";
        TreeNode node = findLCA(root, startValue, destValue);
        Deque<String> deque1 = new LinkedList<>();
        findPath(node, startValue, deque1);
        StringBuilder sb = new StringBuilder();
        while (!deque1.isEmpty()) {
            sb.append("U");
            deque1.remove();
        }
        Deque<String> deque2 = new LinkedList<>();
        findPath(node, destValue, deque2);
        while (!deque2.isEmpty()) {
            sb.append(deque2.removeFirst());
        }
        return sb.toString();
    }

    private boolean findPath(TreeNode node, int val, Deque<String> deque) {
        if (node == null) return false;
        if (node.val == val) return true;
        deque.offer("L");
        if (findPath(node.left, val, deque)) return true;
        deque.removeLast();
        deque.offer("R");
        if (findPath(node.right, val, deque)) return true;
        deque.removeLast();
        return false;
    }

    private TreeNode findLCA(TreeNode root, int startValue, int destValue) {
        if (root == null || root.val == startValue || root.val == destValue) return root;
        TreeNode left = findLCA(root.left, startValue, destValue);
        TreeNode right = findLCA(root.right, startValue, destValue);
        if (left != null && right != null) return root;
        if (left != null) return left;
        return right;
    }
}
