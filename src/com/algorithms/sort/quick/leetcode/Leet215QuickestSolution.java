package com.algorithms.sort.quick.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Leet215QuickestSolution {
    static Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            List<Integer> list = partition(nums, l, r);
            swap(nums, list.get(0), l);
            if (list.get(0) == nums.length - k) return nums[list.get(0)];
            else if (list.get(0) < nums.length - k) {
                l = list.get(1);
            } else {
                r = list.get(0);
            }
        }
        return nums[k];
    }


    private List<Integer> partition(int[] nums, int l, int r) {
        int pivot = l + random.nextInt(r - l);
        swap(nums, l, pivot);
        int p = nums[l];
        int i = l;
        int j = r;
        i++;
        j--;
        int k = i;
        while (k <= j) {
            if (nums[k] == p) {
                k++;
            } else if (nums[k] < p) {
                swap(nums, i, k);
                i++;
                k++;
            } else {
                swap(nums, j, k);
                j--;
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(i - 1);
        list.add(j);
        return list;
    }

    private void swap(int[] arr, int j, int i) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Leet215QuickestSolution test = new Leet215QuickestSolution();
        test.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
    }
}
