package com.algorithms.sort.quick;

import com.algorithms.sort.ArrayGeneration;
import com.algorithms.sort.SortingHelper;

import java.util.Random;

//https://leetcode.com/problems/sort-an-array/ ->leet912
//一般情况时排序速度最块，但是不稳定，当有序时，反而不好；
public class QuickSortPartition3 {
    static Random random = new Random();

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int p = nums[left];
        int start = left + 1;
        int end = right;
        int i = start;
        while (i <= end) {
            if (nums[i] == p) {
                i++;
            } else if (nums[i] < p) {
                swap(nums, i, start);
                i++;
                start++;
            } else {
                swap(nums, i, end);
                end--;
            }
        }
        swap(nums, left, start - 1);
        quickSort(nums, left, start - 2);
        quickSort(nums, end + 1, right);
    }

    private void swap(int[] arr, int j, int i) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = ArrayGeneration.generateRandomArray(1000, 1000);
//        int[] arr = new int[]{7, 6, 5, 4, 3, 2, 1};
        QuickSortPartition3 partition3 = new QuickSortPartition3();
        SortingHelper.isSorted(arr);
    }
}
