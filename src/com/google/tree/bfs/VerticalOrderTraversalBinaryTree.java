package com.google.tree.bfs;

import com.algorithms.binary.search.tree.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class VerticalOrderTraversalBinaryTree {
    class PairNode {
        TreeNode node;
        int index;

        public PairNode(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    //O(nlogn)
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<PairNode> queue = new LinkedList<>();
        queue.add(new PairNode(root, 0));
        while (!queue.isEmpty()) {
            PairNode pairNode = queue.poll();
            TreeNode node = pairNode.node;
            int index = pairNode.index;

            map.putIfAbsent(index, new ArrayList<>());
            map.get(index).add(node.val);
            if (node.left != null) {
                queue.add(new PairNode(node.left, index - 1));
            }
            if (node.right != null) {
                queue.add(new PairNode(node.right, index + 1));
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for (int k : keys) {
            res.add(map.get(k));
        }
        return res;
    }

    //O(n)
    public List<List<Integer>> verticalOrderWithoutSorting(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<PairNode> queue = new LinkedList<>();
        queue.add(new PairNode(root, 0));
        int min = 0;
        int max = 0;
        while (!queue.isEmpty()) {
            PairNode pairNode = queue.poll();
            TreeNode node = pairNode.node;
            int index = pairNode.index;

            map.putIfAbsent(index, new ArrayList<>());
            map.get(index).add(node.val);


            if (node.left != null) {
                queue.add(new PairNode(node.left, index - 1));
                min = Math.min(index - 1, min);
            }
            if (node.right != null) {
                queue.add(new PairNode(node.right, index + 1));
                max = Math.max(index + 1, max);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}
