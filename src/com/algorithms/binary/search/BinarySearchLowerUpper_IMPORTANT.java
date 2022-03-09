package com.algorithms.binary.search;

public class BinarySearchLowerUpper_IMPORTANT {
    static int res = -1;

    int searchCeil(int[] arr, int start, int end, int key) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= key) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    int searchCeilNotIncludeKey(int[] arr, int start, int end, int key) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                start = mid + 1;
            }
            if (arr[mid] > key) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    

    public static void main(String[] args) {
//        System.out.println(searchFloorOfANumber(new int[]{1, 5, 7, 10, 12, 19, 20, 26}, 13));
//        System.out.println(searchCeilingOfANumber(new int[]{1, 5, 7, 10, 12, 19, 20, 26}, 13));
        int[] arr = new int[]{10, 11, 16, 20};
        BinarySearchLowerUpper_IMPORTANT test = new BinarySearchLowerUpper_IMPORTANT();
        System.out.println(arr[test.searchCeilNotIncludeKey(arr, 0, 3, 16)]);
        System.out.println(arr[test.searchCeil(arr, 0, 3, 16)]);

    }
}
