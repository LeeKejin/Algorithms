package com.google.tree;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

public class ConvertTreeToDoubleList {
    Node prev;
    Node head;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        helper(root);
        head.left = prev;
        prev.right = head;
        return head;
    }

    private void helper(Node node) {
        if (node == null) return;
        helper(node.left);
        if (head == null) {
            head = node;
            prev = node;
        } else {
            prev.right = node;
            node.left = prev;
            prev = node;
        }
        helper(node.right);
    }
}
