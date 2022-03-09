package com.google.binary;

public class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            boolean isEvenOnLeft = (r - mid) % 2 == 0;
            if (isEvenOnLeft) {
                if (mid - 1 >= l && nums[mid] == nums[mid - 1]) {
                    r = mid - 2;
                } else if (mid + 1 <= r && nums[mid] == nums[mid + 1]) {
                    l = mid + 2;
                } else {
                    return nums[mid];
                }
            } else {
                if (mid - 1 >= l && nums[mid] == nums[mid - 1]) {
                    l = mid + 1;
                } else if (mid + 1 <= r && nums[mid] == nums[mid + 1]) {
                    r = mid - 1;
                } else {
                    return nums[mid];
                }
            }
        }
        return -1;
    }
}
