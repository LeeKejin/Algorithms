package com.google.wried;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnTheLine {
    public int maxPoints(int[][] points) {
        int ans = 1;
        for (int i = 0; i < points.length; i++) {
            int x[] = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] y = points[j];
                int count = 2;
                for (int k = j + 1; k < points.length; k++) {
                    int z[] = points[k];

                    int k1 = (y[0] - x[0]) * (z[1] - y[1]);
                    int k2 = (z[0] - y[0]) * (y[1] - x[1]);
                    if (k1 == k2) count++;
                }
                ans = Math.max(ans, count);
            }

        }
        return ans;
    }

    /*
    O(n^2 log(n))
     */
    public int maxPoints1(int[][] ps) {
        int n = ps.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            // 由当前点 i 发出的直线所经过的最多点数量
            int max = 0;
            for (int j = i + 1; j < n; j++) {
                int x1 = ps[i][0], y1 = ps[i][1], x2 = ps[j][0], y2 = ps[j][1];
                int a = x1 - x2, b = y1 - y2;
                int k = gcd(a, b);
                String key = (a / k) + "_" + (b / k);
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
            ans = Math.max(ans, max + 1);
        }
        return ans;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
