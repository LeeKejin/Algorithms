package com.google.binary;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int index = findClosestElements(arr, x, k, 0, arr.length - k);
        for (int i = 0; i < k; i++) {
            res.add(arr[i + index]);
        }
        return res;
    }

    private int findClosestElements(int[] arr, int x, int k, int l, int r) {
        if (l == r) return l;
        int mid = l + (r - l) / 2;
        if (x - arr[mid] > arr[mid + k] - x) {
            return findClosestElements(arr, x, k, mid + 1, r);
        }
        return findClosestElements(arr, x, k, l, mid);
    }

    /*
      public List<Integer> findClosestElements(int[] arr, int k, int x) {
      int index = binarySearch(arr, x);
        List<Integer> list = new ArrayList<>();
        if (index == 0) {
            for (int i = 0; i < k; i++) {
                list.add(arr[i]);
            }
            return list;
        }
        if (index == arr.length ) {
            for (int i = arr.length - k; i < arr.length; i++) {
                list.add(arr[i]);
            }
            return list;
        }
        int i = index-1;
        int j = index ;
        while (j - i -1< k) {
            if(i==-1){
                j++;
                continue;
            }
            if (j==arr.length || Math.abs(arr[i] - x) <= Math.abs(arr[j] - x)) {
                i--;
            }else{
                j++;
            }
        }

        for (int n = i+1; n <j; n++) {
            list.add(arr[n]);
        }
        return list;


    }

    private int binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
     */

}
