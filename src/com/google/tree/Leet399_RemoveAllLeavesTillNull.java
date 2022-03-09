package com.google.tree;

import java.util.ArrayList;
import java.util.List;

class Leet366_RemoveAllLeavesTillNull {
    int level = 0;

    public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null) return new ArrayList<>();
        getLevel(root);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < level; i++) {
            List<Integer> list = new ArrayList<>();
            root = removeLeaves(root, list);
            res.add(list);
        }
        return res;
    }

    private TreeNode removeLeaves(TreeNode root, List<Integer> list) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return null;
        }
        root.left = removeLeaves(root.left, list);
        root.right = removeLeaves(root.right, list);
        return root;
    }

    private int getLevel(TreeNode root) {
        if (root == null) return 0;
        int left = getLevel(root.left) + 1;
        int right = getLevel(root.right) + 1;
        level = Math.max(level, Math.max(left, right));
        return Math.max(left, right);
    }
}
