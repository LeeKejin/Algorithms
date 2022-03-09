package com.algorithms.binary.search.tree.leetcode;

public class Leet450 {
//    public static TreeNode deleteNode(TreeNode root, int key) {
//        if (root == null) return null;
//
//        if (root.val == key) {
//            TreeNode min = findMin(root.right);
//            TreeNode right = removeMin(root.right);
//            TreeNode left = root.left;
//
//            if (min != null) {
//                min.left = left;
//                min.right = right;
//                return min;
//            } else {
//                return left;
//            }
//
//        }
//        if (key < root.val) {
//            root.left = deleteNode(root.left, key);
//        } else {
//            root.right = deleteNode(root.right, key);
//        }
//
//        return root;
//    }
//
//    private static TreeNode removeMin(TreeNode root) {
//        if (root == null) return null;
//        if (root.left == null) {
//            return root.right;
//        } else {
//            root.left = removeMin(root.left);
//            return root;
//        }
//    }
//
//    public static TreeNode findMin(TreeNode root) {
//        if (root == null) return null;
//        if (root.left != null) return findMin(root.left);
//        return root;
//
//    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            if (left == null) return right;
            if (right == null) return left;
            TreeNode min = findMin(right);
            root.val = min.val;
            root.right = deleteNode(right, min.val);

        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    private TreeNode findMin(TreeNode node) {
        if (node.left == null) return node;
        return findMin(node.left);
    }
}
