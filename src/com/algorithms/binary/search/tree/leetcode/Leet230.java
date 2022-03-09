package com.algorithms.binary.search.tree.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet230 {
    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list.get(list.size() - 1);
    }

    private static void inOrder(TreeNode root, List<Integer> list) {
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);

    }

    int res = 0;
    int count = 0;

    public int kthSmallest1(TreeNode root, int k) {
        inorder(root, k);
        return res;
    }

    private void inorder(TreeNode root, int k) {
        if (root == null) return;

        inorder(root.left, k);
        count++;
        if (count == k) {
            res = root.val;
            return;
        }

        inorder(root.right, k);
    }

}
