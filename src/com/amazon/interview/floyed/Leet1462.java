package com.amazon.interview.floyed;

import java.util.ArrayList;
import java.util.List;

public class Leet1462 {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] floyed = new boolean[numCourses][numCourses];
        for (int[] pre : prerequisites) {
            floyed[pre[0]][pre[1]] = true;
        }

        for (int mid = 0; mid < numCourses; mid++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    floyed[i][j] = floyed[i][j] || (floyed[i][mid] && floyed[mid][j]);
                }
            }
        }
        List<Boolean> list = new ArrayList<>();
        for (int[] query : queries) {
            list.add(floyed[query[0]][query[1]]);
        }
        return list;
    }
}
