package com.crackingcodeinterview.chapter10;

import java.util.Arrays;

public class WiggleSort_10_11 {
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {

            if (i % 2 == 0) {
                if (nums[i] < nums[i - 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = temp;
                }
            } else {
                if (nums[i] > nums[i - 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = temp;
                }
            }
        }

    }
}
