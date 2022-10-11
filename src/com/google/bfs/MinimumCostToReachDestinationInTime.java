package com.google.bfs;

import java.util.*;

public class MinimumCostToReachDestinationInTime {
    class City {
        int id;
        int fee;
        int time;

        public City(int id, int fee, int time) {
            this.id = id;
            this.fee = fee;
            this.time = time;
        }
    }

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        Map<Integer, List<City>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[0]).add(new City(edge[1], passingFees[edge[1]], edge[2]));
            map.get(edge[1]).add(new City(edge[0], passingFees[edge[0]], edge[2]));
        }
        int minTime[] = new int[passingFees.length];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        int n = passingFees.length - 1;
        int res = Integer.MAX_VALUE;
        PriorityQueue<City> queue = new PriorityQueue<>((c1, c2) -> (c1.fee == c2.fee ? c1.time - c2.time : c1.fee - c2.fee));
        queue.add(new City(0, passingFees[0], 0));

        while (!queue.isEmpty()) {
            int size = queue.size();

            City city = queue.poll();
            if (city.time >= minTime[city.id] || city.time > maxTime) continue;
            minTime[city.id] = city.time;
            if (city.id == n) {
                return city.fee;
            }
            for (City next : map.get(city.id)) {
                if (next.time + city.time <= minTime[next.id] && next.time + city.time <= maxTime) {
                    queue.add(new City(next.id, next.fee + city.fee, next.time + city.time));
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
