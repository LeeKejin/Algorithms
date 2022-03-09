package com.google.heap;

import java.util.Arrays;

public class FindMinArrowShotsOfBalloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> (a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]));
        int count = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end && end <= points[i][1]) {
                continue;
            } else {
                end = points[i][1];
                count++;
            }
        }
        return count;
    }

}
