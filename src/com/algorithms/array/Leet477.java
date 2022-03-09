package com.algorithms.array;

import java.util.Arrays;

public class Leet477 {
    //{4,12,2}
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int max = Arrays.stream(nums).max().getAsInt();
        int count = 0;
        //计算出最大数一共几位 14最大有4位
        while (max > 0) {
            max >>= 1;
            count++;
        }
        int res = 0;
        for (int i = 0; i < count; i++) {
            //第i位上1的数量记到c里
            int c = 0;
            for (int num : nums) {
                if ((num >> i & 1) == 1) {
                    c++;
                }
            }
            //结果累加 每位1的数量*（数组长度-每位1的数量）
            //（数组长度-每位1的数量） 其实就是每位0的数量
            res += c * (n - c);
        }
        return res;
    }

}
