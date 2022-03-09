package com.amazon.interview.floyed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
//https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/discuss/493629/Java-Floyd-SPFA-Dijkstra-and-Bellman

public class Leet1334 {
    //floyed
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] cities = new int[n][n];
        for (int[] city : cities) {
            Arrays.fill(city, Integer.MAX_VALUE);
        }
        for (int i = 0; i < edges.length; i++) {
            int c1 = edges[i][0];
            int c2 = edges[i][1];

            cities[c1][c2] = edges[i][2];
            cities[c2][c1] = edges[i][2];

        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (cities[i][k] != Integer.MAX_VALUE && cities[k][j] != Integer.MAX_VALUE) {
                        cities[i][j] = Math.min(cities[i][j], cities[i][k] + cities[k][j]);
                    }
                }
            }
        }
        int count = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && cities[i][j] <= distanceThreshold) {
                    sum++;
                }
            }
            if (sum <= count) {
                count = sum;
                res = i;
            }
        }
        return res;
    }

    //bellman
    public int findTheCityBellman(int n, int[][] edges, int distanceThreshold) {
        int[][] city = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(city[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            city[i][i] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] edge : edges) {
                    if (city[i][edge[1]] != Integer.MAX_VALUE) {
                        city[i][edge[0]] = Math.min(city[i][edge[0]], city[i][edge[1]] + edge[2]);
                    }

                    if (city[i][edge[0]] != Integer.MAX_VALUE) {
                        city[i][edge[1]] = Math.min(city[i][edge[1]], city[i][edge[0]] + edge[2]);
                    }
                }
            }
        }
        int count = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (city[i][j] <= distanceThreshold) {
                    sum++;
                }
            }
            if (sum <= count) {
                count = sum;
                res = i;
            }
        }
        return res;
    }

    //Dijkstra
    public int findTheCityDijkstra(int n, int[][] edges, int distanceThreshold) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int c1 = edge[0];
            int c2 = edge[1];
            int w = edge[2];
            graph[c1].add(new int[]{c2, w});
            graph[c2].add(new int[]{c1, w});
        }

        int[][] city = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(city[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            city[i][i] = 0;
        }

        for (int i = 0; i < n; i++) {
            PriorityQueue<State> queue = new PriorityQueue<>((a, b) -> a.min - b.min);
            int[] dist = city[i];
            queue.add(new State(0, 0));
            while (!queue.isEmpty()) {
                State cur = queue.poll();
                if (cur.min > dist[cur.id]) continue;
                List<int[]> neighbors = graph[cur.id];
                for (int[] neighbor : neighbors) {
                    int c = neighbor[0];
                    if (dist[c] > dist[cur.id] + neighbor[1]) {
                        dist[c] = dist[cur.id] + neighbor[1];
                        queue.add(new State(c, dist[c]));
                    }
                }
            }
        }


        int count = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (city[i][j] <= distanceThreshold) {
                    sum++;
                }
            }
            if (sum <= count) {
                count = sum;
                res = i;
            }
        }
        return res;
    }

    class State {
        int id;
        int min;

        public State(int id, int min) {
            this.id = id;
            this.min = min;
        }
    }
}
