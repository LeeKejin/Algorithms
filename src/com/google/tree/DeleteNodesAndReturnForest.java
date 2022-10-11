package com.google.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {
    List<TreeNode> list = new ArrayList<>();
    boolean isDeleted = false;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        list.add(root);

        for (int val : to_delete) {
            isDeleted = false;
            for (TreeNode node : list) {
                TreeNode tmp = node;
                node = delete(node, val);
                if (node == null) list.remove(tmp);
                if (isDeleted) break;
            }
        }
        return list;
    }

    private TreeNode delete(TreeNode node, int val) {
        if (node == null) return null;
        if (node.val == val) {
            if (node.left != null) list.add(node.left);
            if (node.right != null) list.add(node.right);
            isDeleted = true;
            return null;
        }
        node.left = delete(node.left, val);
        node.right = delete(node.right, val);
        return node;
    }

    //Solution 2: if delete from the leaves, then looping whole forest is not required
    Set<Integer> set = new HashSet<>();

    public List<TreeNode> delNodes1(TreeNode root, int[] to_delete) {
        for (int val : to_delete) {
            set.add(val);
        }
        root = delete(root);
        if (root != null) list.add(root);
        return list;
    }

    private TreeNode delete(TreeNode node) {
        if (node == null) return null;
        node.left = delete(node.left);
        node.right = delete(node.right);
        if (set.contains(node.val)) {
            if (node.left != null) list.add(node.left);
            if (node.right != null) list.add(node.right);
            return null;
        }

        return node;
    }

}
