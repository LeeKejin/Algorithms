package com.amazon.interview;

public class Leet31 {
    /*
    example 1, 5, 8, 4, 7, 6, 5, 3, 1
    index1 stores the index when reverse back-forth, nums[i]<nums[i+1], in this case, it's 4
     index2 stores the index of the first value bigger than nums[index1],
     from back to forth, 1 less than 4, 3 less than 4, Boom, 5 bigger than 4, and 5's index is 6.
     Then swap the 4 and 5->1, 5, 8, 5, 7, 6, 4, 3, 1
     Then reverse the values after new 5 (old 4's position) ->1, 5, 8, 5,    1,3,4,6,7
     */
    public void nextPermutation(int[] nums) {
        if (nums == null && nums.length == 0) return;
        int index1 = -1;
        int index2 = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index1 = i;
                break;
            }
        }
        if (index1 != -1) {
            for (int j = nums.length - 1; j >= 0; j--) {
                if (nums[j] > nums[index1]) {
                    index2 = j;
                    break;
                }
            }
            //index2 is impossible to be -1, otherwise index1 would be -1
//            if (index2 != -1) {
            swap(nums, index1, index2);
//            }
        }
        reverse(nums, index1 + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
