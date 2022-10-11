package com.crackingcodeinterview.chapter4;

import com.google.tree.TreeNode;

public class SortedArrayToBST_4_2 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return generate(nums, 0, nums.length - 1);
    }

    private TreeNode generate(int[] nums, int start, int end) {
        if (end < start) return null;
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = generate(nums, start, mid - 1);
        node.right = generate(nums, mid + 1, end);
        return node;
    }
}
