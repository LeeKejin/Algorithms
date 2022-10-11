package com.amazon.interview.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class Leet300 {
    //如果num比tails里已更新的最后一个都大（或者第一次添加），直接往tails后添加num；否则通过二分查找找出tails里刚好比num大，但前一个比num小（或没有前一个）的位置，并用num替换掉原来的值。这样可能比较好理解一点。
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
            } else {
                int index = binary(list, nums[i]);
                list.set(index, nums[i]);
                System.out.println(index);
            }
        }
        return list.size();
    }

    //greater then num
    private int binary(List<Integer> list, int num) {
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {

            int mid = l + (r - l) / 2;
            if (list.get(mid) >= num) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
