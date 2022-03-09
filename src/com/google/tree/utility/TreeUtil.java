package com.google.tree.utility;


import com.google.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtil {

    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    sb.append(node.val + ",");
                    queue.add(node.left);
                    queue.add(node.right);
                } else {
                    sb.append("null,");
                }
            }
        }
        String str = sb.toString().substring(0, sb.toString().length() - 1);
        return "[" + str + "]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "[]") return null;
        String str = data.substring(1, data.length() - 1);
        String[] arr = str.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < arr.length) {
            TreeNode node = queue.poll();
            if (!arr[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(arr[i]));
                queue.add(node.left);
            }
            i++;
            if (i < arr.length && !arr[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(arr[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;

    }

    public static void main(String[] args) {
        TreeUtil treeUtil = new TreeUtil();
        TreeNode n = treeUtil.deserialize("[1,2,3,null,null,4,5]");
        treeUtil.serialize(n);
    }
}
