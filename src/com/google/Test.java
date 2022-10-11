package com.google;

import com.google.tree.TreeNode;
import com.google.tree.utility.TreeUtil;

import java.util.*;
import java.util.stream.Collectors;


public class Test {
    //    Map<Integer, Integer> map = new HashMap<>();
    int res = Integer.MAX_VALUE;

    public int maxDistToClosest(int[] seats) {
        int N = seats.length;
        int[] left = new int[N], right = new int[N];
        Arrays.fill(left, N);
        Arrays.fill(right, N);

        for (int i = 0; i < N; ++i) {
            if (seats[i] == 1) left[i] = 0;
            else if (i > 0) left[i] = left[i - 1] + 1;
        }

        for (int i = N - 1; i >= 0; --i) {
            if (seats[i] == 1) right[i] = 0;
            else if (i < N - 1) right[i] = right[i + 1] + 1;
        }

        int ans = 0;
        for (int i = 0; i < N; ++i)
            if (seats[i] == 0)
                ans = Math.max(ans, Math.min(left[i], right[i]));
        return ans;
    }

    public static void main(String[] args) {
        Test test = new Test();
//        test.confusingNumberII(20);
        TreeUtil treeUtil = new TreeUtil();
        TreeNode root = treeUtil.deserialize("[1,null,3,4,4,null,null,null,5]");
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        tree.put(5, 8);
        test.maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1});
    }
}
