package com.google.slidewindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarrayWithSumLeastK_WTF {
    public int shortestSubarray(int[] A, int K) {
        int N = A.length, res = N + 1;
        long[] B = new long[N + 1];
        for (int i = 0; i < N; i++) B[i + 1] = B[i] + A[i];
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < N + 1; i++) {
            while (d.size() > 0 && B[i] - B[d.getFirst()] >= K)
                res = Math.min(res, i - d.pollFirst());
            while (d.size() > 0 && B[i] <= B[d.getLast()])
                d.pollLast();   //i之后会被poll by d.pollFirst， 所以为了res小  d.pollFirst()要尽量大， 所以弹出小的 d.pollLast() index， 放入大的 i
            d.addLast(i);
        }
        return res <= N ? res : -1;
    }
/*
public int shortestSubarray(int[] nums, int target) {
       Deque<Integer> list = new ArrayDeque<>();
        long[] prefixSum = new long[nums.length + 1];//prefix is BLOODY LONG type!!!!!!!!!!!!!
        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        int i = 0;
        int res = nums.length + 1;
        while (i < prefixSum.length) {
            while (!list.isEmpty() && prefixSum[i] - prefixSum[list.getFirst()] >= target) {
                 res = Math.min(res, i - list.removeFirst());
            }
            while (!list.isEmpty() && prefixSum[i] <= prefixSum[list.getLast()]) {
                list.removeLast();
            }
            list.addLast(i);
            i++;
        }
        return res == nums.length + 1?-1:res;
    }
 */
}
