package com.amazon.interview.dijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Leet505 {
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int[][] distance = new int[maze.length][maze[0].length];

        for (int i = 0; i < maze.length; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        distance[start[0]][start[1]] = 0;
        dijkstra(distance, start, maze);
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }

    class State {
        int from;
        int to;
        int dist;

        public State(int from, int to, int dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }
    }

    private void dijkstra(int[][] distance, int[] start, int[][] maze) {
        int dirs[][] = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        PriorityQueue<State> queue = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        queue.add(new State(start[0], start[1], 0));
        while (!queue.isEmpty()) {
            State cur = queue.poll();
            if (cur.dist > distance[cur.from][cur.to]) continue;
            for (int[] dir : dirs) {
                int x = cur.from + dir[0];
                int y = cur.to + dir[1];
                int count = 0;
                while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];

                    count++;
                }
                x -= dir[0];
                y -= dir[1];
                if (distance[x][y] > distance[cur.from][cur.to] + count) {
                    distance[x][y] = distance[cur.from][cur.to] + count;
                    queue.add(new State(x, y, distance[x][y]));
                }
            }
        }
    }
}
