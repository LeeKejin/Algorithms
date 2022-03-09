package com.algorithms.dynamicprogramming.knapsack.zeroone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet322 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0 || coins.length == 0) return 0;
        //dp stores when amount =i, min count, cal from 1->11 if amount =11, dp[i]->when amount =i, the min count
        int dp[] = new int[amount + 1];

        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] < 0) continue;
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }

    public int coinChangeEasyToUnderstand(int[] coins, int amount) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList<>());
        for (int i = 0; i < coins.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(coins[i]);
            map.put(coins[i], list);
        }

        for (int i = 1; i <= amount; i++) {
            if (map.containsKey(i)) {
                List<Integer> list = map.get(i);

                for (int j = 0; j < coins.length; j++) {
                    int sum = i + coins[j];
                    if (sum <= amount) {
                        List<Integer> copiedList = new ArrayList<>(list);
                        if (map.containsKey(sum)) {
                            int size = map.get(sum).size();
                            copiedList.add(coins[j]);
                            if (copiedList.size() < size) {
                                map.put(sum, copiedList);
                            }
                        } else {
                            copiedList.add(coins[j]);
                            map.put(sum, copiedList);
                        }

                    }
                }
            }
        }
        if (map.get(amount) != null) return map.get(amount).size();
        return -1;
    }

    public static void main(String[] args) {
        Leet322 test = new Leet322();
        test.coinChange(new int[]{1, 2, 5}, 11);
    }
}
