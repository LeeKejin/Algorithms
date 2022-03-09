package com.algorithms.binary.search.leetcode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
public class Leet4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (getKth(nums1, 0, nums2, 0, left) + getKth(nums1, 0, nums2, 0, right)) * 0.5;
    }

    private double getKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        int len1 = nums1.length - start1;
        int len2 = nums2.length - start2;
        if (len1 <= 0) return nums2[start2 + k - 1];
        if (len2 <= 0) return nums1[start1 + k - 1];
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);
        int i = start1 + Math.min(k / 2, len1) - 1;
        int j = start2 + Math.min(k / 2, len2) - 1;

        if (nums1[i] < nums2[j]) {
            return getKth(nums1, i + 1, nums2, start2, k - Math.min(k / 2, len1));
        }
        return getKth(nums1, start1, nums2, j + 1, k - Math.min(k / 2, len2));
    }


    List<Integer> list = new ArrayList<>();

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        mergeTwoArray(nums1, nums2, 0, 0);
        if (list.size() == 1) return list.get(0);
        if (list.size() == 2) return (list.get(0) + list.get(1)) / 2.0;

        int mid = list.size() / 2;

        if (list.size() % 2 == 0) {
            return (list.get(mid - 1) + list.get(mid)) / 2.0;
        }
        return (double) list.get(mid);
    }

    private void mergeTwoArray(int[] nums1, int[] nums2, int start1, int start2) {
        if (start1 == nums1.length) {
            add(start2, nums2.length, nums2);
            return;
        }
        if (start2 == nums2.length) {
            add(start1, nums1.length, nums1);
            return;
        }
        if (nums1[start1] <= nums2[start2]) {
            list.add(nums1[start1]);
            mergeTwoArray(nums1, nums2, start1 + 1, start2);
        } else {
            list.add(nums2[start2]);
            mergeTwoArray(nums1, nums2, start1, start2 + 1);
        }
    }

    private void add(int start, int length, int[] num) {
        for (int i = start; i < length; i++) {
            list.add(num[i]);
        }
    }

}
