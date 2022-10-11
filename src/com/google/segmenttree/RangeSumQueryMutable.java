package com.google.segmenttree;

//leet307
public class RangeSumQueryMutable {
    class SegmentTree {
        int[] tree;
        int nums[];

        public SegmentTree(int[] nums) {
            this.tree = new int[nums.length * 4];
            this.nums = nums;
            build(0, 0, nums.length - 1);
        }

        private void build(int treeIndex, int l, int r) {
            if (l == r) {
                tree[treeIndex] = nums[l];
                return;
            }
            int mid = l + (r - l) / 2;
            int left = getLeftIndex(treeIndex);
            int right = getRightIndex(treeIndex);

            build(left, l, mid);
            build(right, mid + 1, r);
            tree[treeIndex] = tree[left] + tree[right];
        }

        int query(int i, int j) {
            return query(0, 0, nums.length - 1, i, j);
        }

        int query(int treeIndex, int l, int r, int i, int j) {
            if (l == i && r == j) {
                return tree[treeIndex];
            }
            int mid = l + (r - l) / 2;
            int left = getLeftIndex(treeIndex);
            int right = getRightIndex(treeIndex);

            if (i > mid) {
                return query(right, mid + 1, r, i, j);
            } else if (j <= mid) {
                return query(left, l, mid, i, j);
            }
            int leftRes = query(left, l, mid, i, mid);
            int rightRes = query(right, mid + 1, r, mid + 1, j);
            return leftRes + rightRes;
        }

        void update(int index, int val) {
            nums[index] = val;
            update(0, 0, nums.length - 1, index, val);
        }

        private void update(int treeIndex, int l, int r, int index, int val) {
            if (l == r) {
                tree[treeIndex] = val;
                return;
            }
            int mid = l + (r - l) / 2;
            int left = getLeftIndex(treeIndex);
            int right = getRightIndex(treeIndex);
            if (index > mid) {
                update(right, mid + 1, r, index, val);
            } else {
                update(left, l, mid, index, val);
            }
            tree[treeIndex] = tree[left] + tree[right];
        }

        private int getLeftIndex(int treeIndex) {
            return treeIndex * 2 + 1;
        }

        private int getRightIndex(int treeIndex) {
            return treeIndex * 2 + 2;
        }
    }

    SegmentTree segmentTree;

    public RangeSumQueryMutable(int[] nums) {
        segmentTree = new SegmentTree(nums);
    }

    public void update(int index, int val) {
        segmentTree.update(index, val);
    }

    public int sumRange(int left, int right) {
        return segmentTree.query(left, right);
    }

    public static void main(String[] args) {
//        RangeSumQueryMutable test = new RangeSumQueryMutable(new int[]{1, 3, 6, 8, 5});
        RangeSumQueryMutable test = new RangeSumQueryMutable(new int[]{1, 2, 3});
//        test.update(2, 3);
    }
}
