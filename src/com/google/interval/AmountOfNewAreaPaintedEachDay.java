package com.google.interval;

public class AmountOfNewAreaPaintedEachDay {
    class Node {
        int leftVal;
        int rightVal;
        Node left;
        Node right;

        public Node(int start, int end) {
            this.leftVal = start;
            this.rightVal = end;
        }
    }

    int count = 0;

    public int[] amountPainted(int[][] paint) {
        Node root = null;
        int res[] = new int[paint.length];
        for (int i = 0; i < paint.length; i++) {
            root = add(root, paint[i][0], paint[i][1]);
            res[i] = count;
            count = 0;
        }
        return res;
    }

    private Node add(Node root, int left, int right) {
        if (root == null) {
            count += right - left;
            return new Node(left, right);
        }
        if (left >= root.leftVal && right <= root.rightVal) return root;
        if (left >= root.rightVal) {
            root.right = add(root.right, left, right);
            return root;
        }
        if (right <= root.leftVal) {
            root.left = add(root.left, left, right);
            return root;
        }
        if (left < root.leftVal) {
            root.left = add(root.left, left, root.leftVal);
        }
        if (right > root.rightVal) {
            root.right = add(root.right, root.rightVal, right);
        }
        return root;
    }
}
