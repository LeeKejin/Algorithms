package com.crackingcodeinterview.chapter4;

import com.google.tree.TreeNode;

public class CheckSubTree_4_10 {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        TreeNode node = find(t1, t2);
        if (node == null) return false;
        return inorder(node, t2);
    }

    private boolean inorder(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1.val != t2.val) {
            return false;
        }
        if (inorder(t1.left, t2.left) && inorder(t1.right, t2.right)) {
            return true;
        }
        return false;
    }

    private TreeNode find(TreeNode t1, TreeNode t2) {
        if (t1 == null) return null;
        if (t1.val == t2.val) return t1;
        TreeNode left = find(t1.left, t2);
        if (left != null) return left;
        return find(t1.right, t2);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);

        TreeNode t2 = new TreeNode(2);

        CheckSubTree_4_10 test = new CheckSubTree_4_10();
        test.checkSubTree(t1, t2);
    }
}
