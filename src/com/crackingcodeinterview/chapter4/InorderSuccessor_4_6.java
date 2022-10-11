package com.crackingcodeinterview.chapter4;

import com.google.tree.TreeNode;
import com.google.tree.utility.TreeUtil;

public class InorderSuccessor_4_6 {
    TreeNode prev = null;
    TreeNode res = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inorder(root, p);
        return res;
    }

    private void inorder(TreeNode root, TreeNode p) {
        if (root == null) return;
        inorder(root.left, p);
        if (p == prev) {
            res = root;
        }
        prev = root;
        inorder(root.right, p);
    }

    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while (root == null) {
            if (root.val <= p.val) {
                root = root.left;
            } else {
                res = root;
                root = root.right;
            }
        }
        return res;
    }

}
