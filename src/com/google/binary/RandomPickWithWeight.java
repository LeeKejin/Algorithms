package com.google.binary;

import java.util.Random;

public class RandomPickWithWeight {
    //比如在有序数组nums = [2,3,5,7]中搜索target = 4，搜索左边界的二分算法会返回 2，你带入上面的说法，都是对的。
    //https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247492884&idx=1&sn=e9583238c67e417df41feaa4ed62871d&chksm=9bd41b1caca3920ac10552e754024ed623e21f19debcbb2061d075f9f0e0a71f181241b47f51&scene=178&cur_album_id=1318896187793260544#rd
    int[] preSum;
    Random random = new Random();

    public RandomPickWithWeight(int[] w) {

        preSum = new int[w.length + 1];
        for (int i = 1; i <= w.length; i++) {
            preSum[i] = w[i - 1] + preSum[i - 1];
        }
    }

    public int pickIndex() {
        int n = random.nextInt(preSum[preSum.length - 1]) + 1;
        int l = 0;
        int r = preSum.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (preSum[mid] >= n) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        while (r >= 0 && preSum[r] == preSum[r - 1]) {
            r--;
        }
        return r;
    }
/*
 public int pickIndex() {
       int n = random.nextInt(preSum[preSum.length - 1]) + 1;
        // int n = 6;
        int l = 0;
        int r = preSum.length;

        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if(mid == preSum.length)return 0;
            if (preSum[mid] <= n) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }
 */

    public static void main(String[] args) {
        RandomPickWithWeight test = new RandomPickWithWeight(new int[]{3, 1, 2, 4});
        System.out.println(test.pickIndex());
    }
}
