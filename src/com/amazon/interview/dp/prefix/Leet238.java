package com.amazon.interview.dp.prefix;

public class Leet238 {
    public int[] productExceptSelf(int[] nums) {
        int temp[] = new int[nums.length];
        temp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            temp[i] = nums[i - 1] * temp[i - 1];
        }
        int back[] = new int[nums.length];
        back[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            back[i] = back[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = back[i] * temp[i];
        }
        return nums;
    }

    public int[] productExceptSelf1(int[] nums) {
        int temp[] = new int[nums.length];
        temp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            temp[i] = temp[i - 1] * nums[i - 1];
        }

        int r = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            temp[i] *= r;
            r *= nums[i];
        }
        return temp;
    }
}
