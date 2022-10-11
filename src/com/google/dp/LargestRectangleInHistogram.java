package com.google.dp;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
    /*
    O(N^2) brutal force
     */
    /*public int largestRectangleArea(int[] heights) {
        int max = Arrays.stream(heights).max().getAsInt();
        int res = 0;
        for (int h = 1; h <= max; h++) {
            int area = 0;
            for (int i = 0; i < heights.length; i++) {
                if (heights[i] >= h) {
                    area += h;
                } else {
                    res = Math.max(res, area);
                    area = 0;
                }
            }
        }
        return res;*/

    /*
    //O(NlogN)
      public int largestRectangleArea(int[] heights) {
        return divideAndConquer(heights, 0, heights.length - 1);
    }

    private int divideAndConquer(int[] heights, int l, int r) {
        if (l > r) return 0;
        int min = l;
        for (int i = l + 1; i <= r; i++) {
            if (heights[i] < heights[min]) {
                min = i;
            }
        }
        return Math.max(heights[min] * (r - l + 1),
                Math.max(divideAndConquer(heights, l, min - 1), divideAndConquer(heights, min + 1, r)));
    }
     */

    /*
    O(N)
     */
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                int h = heights[stack.pop()];
                int w = i - stack.peek() - 1;
                res = Math.max(res, w * h);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int h = heights[stack.pop()];
            int w = heights.length - stack.peek() - 1;
            res = Math.max(res, w * h);
        }
        return res;
    }

}
