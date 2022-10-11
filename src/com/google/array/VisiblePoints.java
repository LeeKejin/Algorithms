package com.google.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Short explanation is that the list of angles is not circular and you can't 'circle back' and check the angles prior to the first angle in the list. Ok, long version is ...
 * <p>
 * E.g. if this is your list of sorted angles [-179, -92, -10, 7, 55, 164, 167] and you vision angle is 90, (Plot this on a paper and it will help understand it a lot better!!).
 * <p>
 * Let's start from the first angle -179, plug it into the algorithm above, the max visible points for this point would be 1, which is just -179 itself. However, if you check the angle plot, you will find [-179, 167, 164] are also within the visible range, but at the moment, the algorithm is not able to check that region yet, cuz -179 is the first element in the angle list.
 * <p>
 * To cover that you you don't want the algorithm stop at last angle 7 but instead, to let it iterate back -179 to cover the region the algorithm has not yet checked at the beginning ( the region on -179's clock-wise side).
 * <p>
 * To achieve that, you need to add the additional 360 to the original list and append it to the original lis and you will get [-179, -92, -10, 7, 55, 164, 167, 181, 268, 350, 367, 415, 524, 527].
 * Then after checking 7, you will look at angle 181 (or -179) but at this time,
 * the algorithm is able to compare 181 with [164, 167]. Apparently, they are all within the visible range
 * and the max visible points for this point would be 3 rather than 1
 */
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
