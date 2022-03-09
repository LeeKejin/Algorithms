package com.google.tree.dfs;

import com.google.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet863 {
    Map<Integer, TreeNode> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null) return new ArrayList<>();
        findParent(root, null);

        find(target, null, k, 0);
        return list;
    }


    private void find(TreeNode node, TreeNode from, int k, int cur) {
        if (node == null) return;
        if (k == cur) {
            list.add(node.val);
            return;
        }
        if (node.left != from) {
            find(node.left, node, k, cur + 1);
        }
        if (node.right != from) {
            find(node.right, node, k, cur + 1);
        }
        if (map.get(node.val) != from) {
            find(map.get(node.val), node, k, cur + 1);

        }

    }

    private void findParent(TreeNode node, TreeNode parent) {
        if (node == null) return;
        map.put(node.val, parent);
        findParent(node.left, node);
        findParent(node.right, node);
    }
}
