package com.google.segmenttree;

public class RangeSumQueryImmutable {
    int tree[];
    int nums[];

    public RangeSumQueryImmutable(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        tree = new int[n * 4];
        build(0, 0, nums.length - 1);
    }

    private void build(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = nums[l];
            return;
        }
        int left = getLeftChild(treeIndex);
        int right = getRightChild(treeIndex);
        int mid = l + (r - l) / 2;
        build(left, l, mid);
        build(right, mid + 1, r);
        tree[treeIndex] = tree[left] + tree[right];
    }

    int query(int l, int r) {
        return query(0, 0, nums.length - 1, l, r);
    }

    private int query(int treeIndex, int leftBoundary, int rightBoundary, int l, int r) {
        if (l == leftBoundary && r == rightBoundary) {
            return tree[treeIndex];
        }
        int left = getLeftChild(treeIndex);
        int right = getRightChild(treeIndex);
        int mid = leftBoundary + (rightBoundary - leftBoundary) / 2;
        if (l > mid) {
            return query(right, mid + 1, rightBoundary, l, r);
        } else if (r <= mid) {
            return query(left, leftBoundary, mid, l, r);
        }

        int leftVal = query(left, leftBoundary, mid, l, mid);
        int rightVal = query(right, mid + 1, rightBoundary, mid + 1, r);
        return leftVal + rightVal;
    }

    int getLeftChild(int index) {
        return index * 2 + 1;
    }

    int getRightChild(int index) {
        return index * 2 + 2;
    }

    public int sumRange(int left, int right) {
        return query(left, right);
    }
}
