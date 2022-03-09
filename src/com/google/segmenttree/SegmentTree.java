package com.google.segmenttree;

public class SegmentTree {
    private int data[];
    private int tree[];

    public SegmentTree(int[] arr) {
        this.data = new int[arr.length];
        this.tree = new int[arr.length * 4];

        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        build(0, 0, data.length - 1);
    }

    private void build(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int left = leftChild(treeIndex);
        int right = rightChild(treeIndex);
        int mid = l + (r - l) / 2;
        build(left, l, mid);
        build(right, mid + 1, r);
//        tree[treeIndex] = Math.max(tree[left] , tree[right]);//max/min
        tree[treeIndex] = tree[left] + tree[right];//sum

    }

    public int query(int queryL, int queryR) {
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    //l,r is the range of treeNode with treeIndex
    private int query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }
        int mid = l + (r - l) / 2;
        int left = leftChild(treeIndex);
        int right = rightChild(treeIndex);
        if (queryL > mid) {
            return query(right, mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) {
            return query(left, l, mid, queryL, queryR);
        }
        int leftResult = query(left, l, mid, queryL, mid);
        int rightResult = query(right, mid + 1, r, mid + 1, queryR);
        return leftResult + rightResult; //sum
//        return Math.max(leftResult,rightResult) //max or min

    }

    private void update(int index, int val) {
        data[index] = val;
        update(0, 0, data.length - 1, index, val);
    }

    private void update(int treeIndex, int l, int r, int index, int val) {
        if (l == r) {
            tree[treeIndex] = val;
        }
        int mid = l + (r - l) / 2;
        int left = leftChild(treeIndex);
        int right = rightChild(treeIndex);
        if (index > mid) {
            update(right, mid + 1, r, index, val);
        } else {
            update(left, l, mid, index, val);
        }
        tree[treeIndex] = tree[left] + tree[right];
    }

    int leftChild(int index) {
        return 2 * index + 1;
    }

    int rightChild(int index) {
        return 2 * index + 2;
    }
}
