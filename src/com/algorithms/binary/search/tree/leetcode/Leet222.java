package com.algorithms.binary.search.tree.leetcode;

public class Leet222 {
    int getDepth(TreeNode root) {
        int d = 0;
        if (root == null) return 0;
        while (root != null) {
            root = root.left;
            d++;
        }
        return d - 1;
    }

    //小于x的最大值
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int d = getDepth(root);
        int l = 0;
        int r = (int) Math.pow(2, d) - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (exists(root, mid, d)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        return (int) Math.pow(2, d) + l;
    }

    //大于x的最小值
    private boolean exists(TreeNode root, int target, int d) {
        int l = 0;
        int r = (int) Math.pow(2, d) - 1;
        for (int i = 0; i < d; i++) {
            int mid = l + (r - l) / 2;
            if (target <= mid) {
                root = root.left;
                r = mid;
            } else {
                root = root.right;
                l = mid + 1;
            }
        }
        return root != null;
    }
}
