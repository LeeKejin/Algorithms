package com.algorithms.sort.shell;

public class ShellSort {
    int[] shellSort(int[] arr) {
        for (int interval = arr.length / 2; interval > 0; interval /= 2) {
            for (int i = interval; i < arr.length; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= interval && arr[j - interval] > temp; j -= interval) {
                    arr[j] = arr[j - interval];
                }
                arr[j] = temp;//arr[j]离存左边比arr[i]大的最小值
            }
        }
        return arr;
    }

    int[] sort(int arr[]) {
        for (int interval = arr.length / 2; interval > 0; interval /= 2) {
            for (int i = interval; i < arr.length; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= interval && arr[j - interval] > arr[j]; j -= interval) {
                    arr[j] = arr[j - interval];
                }
                arr[j] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        shellSort.shellSort(new int[]{9, 8, 3, 7, 5, 6, 4, 1});
    }

}
