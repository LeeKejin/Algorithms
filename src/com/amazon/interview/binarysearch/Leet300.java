package com.amazon.interview.binarysearch;

public class Leet300 {
    //如果num比tails里已更新的最后一个都大（或者第一次添加），直接往tails后添加num；否则通过二分查找找出tails里刚好比num大，但前一个比num小（或没有前一个）的位置，并用num替换掉原来的值。这样可能比较好理解一点。
    public int lengthOfLIS(int[] nums) {
        int[] tail = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            if (res == 0 || num > tail[res - 1]) {
                tail[res] = num;
                res++;
            } else {
                int i = 0;
                int j = res;
                while (i < j) {
                    int m = i + (j - i) / 2;
                    if (tail[m] < num) {
                        i = m + 1;
                    } else {
                        j = m;
                    }
                }
                tail[i] = num;
            }
        }
        return res;
    }
}
