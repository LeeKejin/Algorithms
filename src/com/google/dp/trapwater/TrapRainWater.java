package com.google.dp.trapwater;

import java.util.Stack;

public class TrapRainWater {
    //rain
    public int trapDP(int[] height) {
        if (height.length <= 2) return 0;
        int n = height.length;
        int sum = 0;
        int left[] = new int[n];
        int right[] = new int[n];
        left[0] = height[0];
        int max = height[0];
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, height[i]);
            left[i] = max;
        }
        max = height[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            right[i] = max;
        }
        for (int i = 0; i < n; i++) {
            int min = Math.min(left[i], right[i]);
            if (min > height[i]) {
                sum += (min - height[i]);
            }
        }
        return sum;
    }

    public int trap(int[] height) {
        if (height.length <= 2) return 0;
        int n = height.length;
        int sum = 0;
        for (int i = 1; i < n - 1; i++) {
            int left = height[i - 1];
            for (int j = i - 1; j >= 0; j--) {
                left = Math.max(left, height[j]);
            }
            int right = height[i + 1];
            for (int k = i + 1; k < n; k++) {
                right = Math.max(right, height[k]);
            }
            int min = Math.min(left, right);
            if (min > 0 && min - height[i] > 0) {
                sum += (min - height[i]);
            }
        }
        return sum;
    }

    public int trapStack(int[] height) {
        Stack<int[]> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && stack.peek()[0] < height[i]) {
                int val[] = stack.pop();
                if (stack.isEmpty()) break;
                int left[] = stack.peek();
                sum += ((Math.min(height[i], left[0]) - val[0]) * (i - left[1] - 1));

            }
            stack.push(new int[]{height[i], i});
        }
        return sum;
    }
}
