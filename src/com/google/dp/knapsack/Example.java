package com.google.dp.knapsack;

public class Example {
    /*
   完全背包，数组中的每个值可以取不止1次， 所以背包size要从小到大遍历， 因为每次遍历后一个数都会加上前一个数的值， 当物品0的w=1 value=15， size=1时value=15，但当size=2时 value=15+15=30
    */
    void test(int[] weights, int[] values, int size) {

        int dp[] = new int[size + 1];
        dp[0] = 0;
        for (int i = 0; i < weights.length; i++) {
            for (int j = weights[i]; j <= size; j++) {
                int val = dp[j - weights[i]] + values[i];
                dp[j] = Math.max(dp[j], val);
            }
        }
        System.out.println(dp[size]);
    }

    /*
       完全背包，数组中的每个值可以取1次， 所以背包size要从大到小遍历， 因为每次遍历后一个数都会加上前一个数的值 （从大到小遍历时，前面的值还没有update，因此不会把背包里的ob加多次！）， 当物品0的w=1 value=15， size=4时value=15，当size=3时
       value=15，当size=2时 value=1。。。
        */
    void test01(int[] weights, int[] values, int size) {

        int dp[] = new int[size + 1];
        dp[0] = 0;
        for (int i = 0; i < weights.length; i++) {
            for (int j = size; j >= weights[i]; j--) {
                int val = dp[j - weights[i]] + values[i];
                dp[j] = Math.max(dp[j], val);
            }
        }
        System.out.println(dp[size]);
    }


    public static void main(String[] args) {
        Example example = new Example();
        example.test01(new int[]{1, 3, 4}, new int[]{15, 20, 30}, 4);
    }
}
