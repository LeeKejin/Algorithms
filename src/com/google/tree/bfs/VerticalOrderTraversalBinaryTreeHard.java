package com.google.tree.bfs;

import com.google.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class VerticalOrderTraversalBinaryTreeHard {
    class State {
        int index;
        int col;
        TreeNode node;

        public State(int index, int col, TreeNode node) {
            this.index = index;
            this.col = col;
            this.node = node;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Map<Integer, List<State>> map = new TreeMap<>();
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, 0, root));
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                State state = queue.poll();
                int index = state.index;
                TreeNode node = state.node;

                map.putIfAbsent(index, new ArrayList<>());
                map.get(index).add(state);

                if (node.right != null) {
                    queue.add(new State(index + 1, level, node.right));
                }
                if (node.left != null) {
                    queue.add(new State(index - 1, level, node.left));
                }
            }
            level++;
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int index : map.keySet()) {
            Collections.sort(map.get(index), (s1, s2) -> s1.col == s2.col ? s1.node.val - s2.node.val : s1.col - s2.col);
            res.add(map.get(index).stream().map(m -> m.node.val).collect(Collectors.toList()));
        }
        return res;
    }
}
