package com.google.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class KnightMoves {
    /*
    In my understanding, we have the constraints |x| + |y| <= 300 which means that x = -300, and y = 0 can exist. Thus, for x and y, their individual range is [-300, 300]. However, we cannot use 600 directly and if we use it, we will get an indexOutOfBoundExceptions, the reason is because we have offsets: int[][] offsets = {{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1},{-1,2}}.

This means that when x = 300, the range might go up to 302 if we add the offset {2,1} or {2,-1} to it and go down to -302 when x = -300 and we add the offset {-2,-1} or{-2,1} to it.

Thus we have the actual bound for x and for y as [-302, 302] which is a total of 604 in bitmap, and lets add 1 to avoid indexOutOfBoundException.

From this, we can understand that 302 and 605 are all minimum number that can pass the test, and all values larger than these two can also pass the tests. If we use 303 and 607, it can also pass. But to notice that 607 can pass because 607 = 303-(-303) + 1. If we use 303 and 605, we will meet with indexOutOfBoundException because 605 < 303-(-303)+1.
     */

    public int minKnightMoves(int x, int y) {
        boolean[][] visited = new boolean[607][607];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int count = 0;
        int[][] dirs = new int[][]{{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pair = queue.poll();
                int x1 = pair[0];
                int y1 = pair[1];
                if (x1 == x && y1 == y) return count;
                for (int[] dir : dirs) {
                    int newX = x1 + dir[0];
                    int newY = y1 + dir[1];
//                    if (newX == x && newY == y) {
//                        return count + 1;
//                    }
                    if (visited[newX + 302][newY + 302]) continue;
                    visited[newX + 302][newY + 302] = true;
                    queue.add(new int[]{newX, newY});
                }
            }
            count++;
        }
        return -1;
    }
}

