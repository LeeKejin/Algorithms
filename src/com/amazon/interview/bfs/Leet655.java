package com.amazon.interview.bfs;

import com.amazon.interview.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Leet655 {

    class Location {
        TreeNode node;
        int row;
        int start;
        int end;

        public Location(TreeNode node, int row, int start, int end) {
            this.node = node;
            this.row = row;
            this.start = start;
            this.end = end;
        }
    }

    public List<List<String>> printTree(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int height = getHeight(queue);
        int col = (int) Math.pow(2, height) - 1;
        String[][] res = new String[height][col];
        for (int i = 0; i < height; i++) {
            Arrays.fill(res[i], "");
        }
        Queue<Location> locations = new LinkedList<>();
        locations.add(new Location(root, 0, 0, col));
        while (!locations.isEmpty()) {
            int size = locations.size();
            for (int i = 0; i < size; i++) {
                Location location = locations.poll();
                TreeNode node = location.node;
                int r = location.row;
                int c = location.start + (location.end - location.start) / 2;
                res[r][c] = String.valueOf(node.val);
                if (node.left != null) {
                    locations.add(new Location(node.left, r + 1, location.start, c));
                }
                if (node.right != null) {
                    locations.add(new Location(node.right, r + 1, c + 1, location.end));
                }
            }
        }
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            list.add(Arrays.asList(res[i]));
        }
        return list;
    }

    private int getHeight(Queue<TreeNode> queue) {
        Map<TreeNode, int[]> map = new HashMap<>();
        int height = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            height++;
        }
        return height;
    }
}
