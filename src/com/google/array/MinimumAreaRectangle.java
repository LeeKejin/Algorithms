package com.google.array;

//import com.sun.tools.javac.util.Pair;

import java.util.HashSet;
import java.util.Set;

public class MinimumAreaRectangle {
//    public int minAreaRect(int[][] points) {
//        Set<Pair<Integer, Integer>> set = new HashSet<>();
//        for (int p[] : points) {
//            set.add(new Pair<>(p[0], p[1]));
//        }
//        int area = Integer.MAX_VALUE;
//        for (int i = 0; i < points.length; i++) {
//            for (int j = i + 1; j < points.length; j++) {
//                int[] p1 = points[i];
//                int[] p3 = points[j];
//                if (p1[0] != p3[0] && p1[1] != p3[1]) {
//                    int p2X = p3[0];
//                    int p2Y = p1[1];
//
//                    int p4X = p1[0];
//                    int p4Y = p3[1];
//                    if (set.contains(new Pair<>(p2X, p2Y)) && set.contains(new Pair<>(p4X, p4Y))) {
//                        int n = Math.abs(p1[0] - p3[0]) * Math.abs(p1[1] - p3[1]);
//                        area = Math.min(area, n);
//                    }
//                }
//            }
//        }
//        return area == Integer.MAX_VALUE ? 0 : area;
//    }
}
