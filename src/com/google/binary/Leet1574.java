package com.google.binary;

public class Leet1574 {

    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int index1 = 1, index2 = n - 2;
        //分别从两头找到相应的递增数组下标
        for (; index1 < n; index1++) {
            if (arr[index1] < arr[index1 - 1]) break;
        }
        for (; index2 >= 0; index2--) {
            if (arr[index2] > arr[index2 + 1]) break;
        }
        //左区间右下标
        index1--;
        //右区间左下标
        index2++;
        //该数组本来就是递增数组 ， 返回0
        if (index1 >= index2) return 0;
        //刚好可以把这两个数组合并 ， 返回中间未合并的数的个数
        if (arr[index1] <= arr[index2]) return index2 - index1 - 1;
        int ans = Math.min(n - index1 - 1, index2);
        //两个区间不相交
        if (arr[0] > arr[n - 1]) return ans;
        for (int i = 0; i <= index1; i++) {
            int l = index2, r = n - 1;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (arr[i] > arr[mid]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            //得出当前 arr[i] <= arr[l]
            //对于二分查找的最右边的情况，需要判断能否进行合并
            if (l == n - 1 && arr[i] > arr[l]) l++;
            ans = Math.min(ans, l - i - 1);
        }
        return ans;

    }

}
