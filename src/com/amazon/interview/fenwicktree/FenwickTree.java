package com.amazon.interview.fenwicktree;

public class FenwickTree {
    int sums[];

    private int lowbit(int i) {
        return i & (-i);
    }

    public FenwickTree(int n) {
        sums = new int[n + 1];
    }

    public void update(int i, int val) {
        while (i < sums.length) {
            sums[i] += val;
            i += lowbit(i);
        }
    }

    public int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += sums[i];
            i -= lowbit(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5};
        FenwickTree ft = new FenwickTree(arr.length);
        for (int i = 0; i < arr.length; i++) {
            ft.update(i + 1, arr[i]);
        }
        System.out.println(ft.query(3) - ft.query(0));

        //sum from 2-4, include 2, 2+3+4=9 -> ft.query(4)-ft.query(1)
//        System.out.println(ft.query(4) - ft.query(1));
    }

}
