package com.google.binary.lowerbound;

public class LowerBound {
    public int[] searchRangeLower(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int index = lowerBound(nums, target);
        if (index == -1 || nums[index] != target) return new int[]{-1, -1};
        int i;
        int k = index;
        for (i = index; i < nums.length; i++) {
            if (nums[i] != target) break;
        }
        return new int[]{k, i - 1};
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int index = higherBound(nums, target);
        if (index == nums.length || nums[index] != target) return new int[]{-1, -1};
        int i;
        for (i = index; i >= 0; i--) {
            if (nums[i] != target) break;
        }
        return new int[]{i + 1, index};
    }


    private int lowerBound(int[] nums, int target) {
        int N = nums.length;
        int begin = 0, end = N - 1;

        while (begin <= end) {

            int mid = (begin + end) / 2;

            if (nums[mid] == target) {


                // This means we found our lower bound.
                if (mid == begin || nums[mid - 1] != target) {
                    return mid;
                }

                // Search on the left side for the bound.
                end = mid - 1;


            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }

        return end;
    }

    private int higherBound(int nums[], int target) {
        int N = nums.length;
        int begin = 0, end = N - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (nums[mid] == target) {
                if (mid == end || nums[mid + 1] != target) {
                    return mid;
                }
                begin = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return begin;
    }

    int higherBound1(int[] letters, int target) {

        int l = 0;
        int r = letters.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (letters[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }


    int searchHighBoundary(int arr[], int target) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    int searchLowBoundary(int arr[], int target) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (arr[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }


    int search(int[] arr, int target) {
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
        return r;//l
    }

    int searchDiff(int[] arr, int target) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;//l
    }

    public static void main(String[] args) {
        LowerBound lb = new LowerBound();
//        System.out.println(lb.searchHighBoundary(new int[]{1, 2, 3, 4, 7, 7, 9}, 8));
//        System.out.println(lb.searchLowBoundary(new int[]{1, 2, 3, 4, 7, 7, 9}, 8));

        System.out.println(lb.search(new int[]{1, 2, 3, 4, 9}, 10));//5-->l
        System.out.println(lb.search(new int[]{1, 2, 3, 4, 9}, 10));//4-->r
        System.out.println(lb.search(new int[]{1, 2, 3, 4, 9}, 0));//0-->l
        System.out.println(lb.search(new int[]{1, 2, 3, 4, 9}, 0));//-1-->r

//        System.out.println(lb.lowerBound(new int[]{5, 5, 7, 7, 8, 8, 10}, 6));//1
//        System.out.println(lb.lowerBound(new int[]{5, 5, 7, 7, 8, 8, 10}, 4));
//        System.out.println(lb.higherBound(new int[]{5, 5, 7, 7, 8, 8, 10}, 7));//3
//        System.out.println(lb.higherBound1(new int[]{5, 5, 7, 7, 8, 8, 10}, 7));//2
//
//        System.out.println(lb.higherBound(new int[]{5, 5, 7, 7, 8, 8, 10}, 6));//2
//        System.out.println(lb.higherBound1(new int[]{5, 5, 7, 7, 8, 8, 10}, 6));//2
//        System.out.println(lb.lowerBound(new int[]{5, 7, 7, 8, 8, 10}, 4));
    }
}
