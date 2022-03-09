package com.algorithms.sort;

public class SelectionSort {

    public void selectionSort(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            int index = i; //index must euqal to i
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[index]) {
                    index = j;
                }
            }

            if (index != i) swap(nums, i, index);
        }
    }

    private void swap(int[] arr, int j, int i) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static <E extends Comparable<E>> void executeReverse(E[] arr) {

        for (int i = arr.length - 1; i >= 0; i--) {
            int minIndex = i;

            for (int j = i; j >= 0; j--) {
                if (arr[j].compareTo(arr[minIndex]) > 0) {
                    minIndex = j;
                }
            }
            E temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            minIndex = i;

        }

        System.out.println("Sorted: " + SortingHelper.isSorted(arr));
    }

}
