package com.algorithms.binary.search.tree.leetcode;


public class Leet108_1 {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode node = bst(nums, 0, nums.length - 1);
        return node;
    }

    private TreeNode bst(int[] nums, int start, int end) {
        if (start < end) return null;
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = bst(nums, start, mid - 1);
        node.right = bst(nums, mid + 1, end);
        return node;
    }


}
