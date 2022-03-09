package com.google.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VisiblePoints {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>();

        int count = 0;
        for (List<Integer> point : points) {
            int x = point.get(0);
            int y = point.get(1);
            int dx = x - location.get(0);
            int dy = y - location.get(1);
            if (dx == 0 && dy == 0) {
                count++;
            } else {
                angles.add(Math.toDegrees(Math.atan2(dy, dx)));
            }
        }

        List<Double> tmp = new ArrayList<>(angles);
        for (Double degree : angles) {
            tmp.add(360 + degree);
        }
        Collections.sort(tmp);
        int j = 0;
        int res = count;
        for (int i = 0; i < tmp.size(); i++) {
            while (tmp.get(i) - tmp.get(j) > angle) {
                j++;
            }
            res = Math.max(res, count + i - j + 1);
        }
        return res;
    }

}
