package com.google.segmenttree;

public class Leet729 {
    class TreeNode {
        int start;
        int end;
        TreeNode left;
        TreeNode right;

        public TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    TreeNode root;

    public boolean book(int start, int end) {
        if (root == null) {
            root = new TreeNode(start, end);
            return true;
        }
        TreeNode parent = null;
        TreeNode node = root;
        while (node != null) {
            parent = node;
            if (node.end <= start) {
                node = node.right;
            } else if (node.start >= end) {
                node = node.left;
            } else {
                return false;
            }
        }
        TreeNode newNode = new TreeNode(start, end);
        if (end <= parent.start) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        return true;
    }

}
