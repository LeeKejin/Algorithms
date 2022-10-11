package com.crackingcodeinterview.chapter10;

public class Search_10_3 {
    public int search(int[] arr, int target) {
        if (arr[0] == target)
            return 0;
        int l = 0;
        int r = arr.length - 1;
        int mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            //mid值==target,则继续往左搜寻，找到最小的索引，最小索引一定不为0
            if (arr[mid] == target) {
                while (mid > 0 && arr[mid - 1] == arr[mid]) mid--;
                return mid;
            }
            //说明mid~r是递增序列，判读target是否在中间
            if (arr[mid] < arr[r]) {
                if (arr[mid] < target && target <= arr[r]) l = mid + 1;
                else r = mid - 1;
            }
            //说明 l~mid 是递增序列，判读target是否在中间
            else if (arr[mid] > arr[r]) {
                if (arr[l] <= target && target < arr[mid]) r = mid - 1;
                else l = mid + 1;
            }
            //arr[mid]==arr[r]说明要么r~0~mid都相等，要么mid~r都相等，无论哪种r 都可以舍去
            else {
                r--;
            }
        }
        return -1;
    }


    public int search1(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                while (mid >= 0 && arr[mid] == target) {
                    mid--;
                }
                return mid + 1;

            }
            if (arr[mid] < arr[r]) {
                if (arr[mid] < target && target <= arr[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else if (arr[mid] > arr[r]) {
                if (arr[l] <= target && target < arr[mid]) r = mid - 1;
                else l = mid + 1;

            } else {
                r--;
            }


        }
        return -1;
    }
}
