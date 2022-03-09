package com.amazon.interview.bfs;

import com.algorithms.graph.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leet366 {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        while (root != null) {
            List<Integer> list = new ArrayList<>();
            root = findAndDeleteLeaves(root, list);
            results.add(list);
        }
        return results;
    }

    private TreeNode findAndDeleteLeaves(TreeNode root, List<Integer> list) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return null;
        }
        root.left = findAndDeleteLeaves(root.left, list);
        root.right = findAndDeleteLeaves(root.right, list);
        return root;
    }
}
