package com.google.calander;

public class MyCalendarWithTreeFast {
    /*
    O(logN)
     */
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
        TreeNode node = root;
        TreeNode parent = null;
        while (node != null) {
            parent = node;
            if (node.start >= end) {
                node = node.left;
            } else if (node.end <= start) {
                node = node.right;
            } else {
                return false;
            }
        }
        if (parent.start >= end) {
            parent.left = new TreeNode(start, end);
        } else {
            parent.right = new TreeNode(start, end);
        }
        return true;
    }
}
