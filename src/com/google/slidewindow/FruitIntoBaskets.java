package com.google.slidewindow;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    /* public int totalFruit(int[] fruits) {
         if (fruits.length == 0) return 0;
         if (fruits.length == 1) return 1;
         int i = 1;
         Map<Integer, Integer> map = new HashMap<>();
         map.put(fruits[0], 1);
         int start = 0;
         int count = 1;
         int res = 0;
         while (i < fruits.length) {
             if (map.keySet().contains(fruits[i]) || map.size() < 2) {
                 count++;
                 map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
                 i++;
             } else if (map.size() == 2) {
                 res = Math.max(res, count);

                 while (map.size() == 2) {
                     map.put(fruits[start], map.get(fruits[start]) - 1);
                     count--;
                     if (map.get(fruits[start]) == 0) {
                         map.remove(fruits[start]);
                     }
                     start++;
                 }

             }
         }
         return Math.max(res, count);
     }*/
    public int totalFruit(int[] fruits) {
        int i = 0;
        int start = 0;
        int dp[] = new int[fruits.length];
        int res = 0;
        int k = 2;
        while (i < fruits.length) {
            if (dp[fruits[i]] == 0) k--;
            dp[fruits[i]]++;
            while (k < 0) {
                dp[fruits[start]]--;
                if (dp[fruits[start]] == 0) k++;
                start++;
            }
            res = Math.max(res, i - start + 1);
            i++;
        }
        return res;
    }

}
