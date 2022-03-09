package com.google.tree;

import java.util.ArrayList;
import java.util.List;

public class Leet1325 {
    //后序遍历
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return null;

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
    }

    /*
    remove all leaves
     */
    public TreeNode removeAllNodesFromLeaves(TreeNode root, int target) {
        if (root == null) return null;
        getLevel(root);
        for (int i = 0; i < level; i++) {
            root = remove(root);
            System.out.println(list);
            list.clear();

        }
        return root;
    }

    List<Integer> list = new ArrayList<>();
    int level = 0;

    int getLevel(TreeNode node) {
        if (node == null) return 0;
        int left = getLevel(node.left) + 1;
        int right = getLevel(node.right) + 1;
        level = Math.max(left, Math.max(left, right));
        return Math.max(left, right);
    }


    private TreeNode remove(TreeNode node) {
        if (node == null) return null;
        if (node.left == null && node.right == null) {
            list.add(node.val);
            return null;
        }
        node.left = remove(node.left);
        node.right = remove(node.right);
        return node;
    }


}
