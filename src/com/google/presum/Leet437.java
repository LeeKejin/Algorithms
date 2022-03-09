package com.google.presum;

import com.algorithms.binary.search.tree.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Leet437 {
    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        presum(root, 0, targetSum, map);
        return count;
    }

    private void presum(TreeNode node, int sum, int targetSum, Map<Integer, Integer> map) {
        if (node == null) return;
        sum += node.val;
        count += map.getOrDefault(sum - targetSum, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        presum(node.left, sum, targetSum, map);
        presum(node.right, sum, targetSum, map);
        map.put(sum, map.get(sum) - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        root.right.right = new TreeNode(11);

    }

}
