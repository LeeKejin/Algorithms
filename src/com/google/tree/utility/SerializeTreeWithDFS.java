package com.google.tree.utility;

import com.google.tree.TreeNode;

public class SerializeTreeWithDFS {
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        inorder(root, sb);

        return sb.deleteCharAt(sb.length() - 1).append("]").toString();
    }

    private void inorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }

        sb.append(root.val).append(",");
        inorder(root.left, sb);
        inorder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;
        data = data.substring(1, data.length() - 1);
        String strs[] = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));

        reDeserialize(root, strs);
        return root;
    }

    int i = 1;

    private TreeNode reDeserialize(TreeNode root, String[] strs) {
        if (i > strs.length) return null;
        if (!strs[i].equals("null")) {
            TreeNode left = new TreeNode(Integer.parseInt(strs[i]));
            i++;
            root.left = reDeserialize(left, strs);
        } else {
            i++;
        }
        if (!strs[i].equals("null")) {
            TreeNode right = new TreeNode(Integer.parseInt(strs[i]));
            i++;
            root.right = reDeserialize(right, strs);
        } else {
            i++;
        }
        return root;
    }
}
