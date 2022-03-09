package com.amazon.interview.dijkstra;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
https://leetcode.com/problems/path-with-maximum-probability/

https://leetcode.com/problems/network-delay-time/

https://leetcode.com/problems/the-maze-ii/

https://leetcode.com/problems/the-maze-iii/

https://leetcode.com/problems/path-with-minimum-effort/

https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/

"Articulation points" and "bridges"

https://leetcode.com/discuss/general-discussion/709997/questions-based-on-articulation-points-and-bridges/799168
 */
public class Leet743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        if (times.length < n - 1) return 0;
        //one array has multi lists, onr list store multi neighbour with weight

        List<int[]>[] graph = new LinkedList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < times.length; i++) {
            int from = times[i][0];
            int to = times[i][1];
            graph[from].add(new int[]{to, times[i][2]});
        }

        int[] prob = dijkstra(k, graph);
        int res = 0;
        for (int p : prob) {
            if (p == Integer.MAX_VALUE) return -1;
            res = Math.max(res, p);
        }
        return res;
    }

    class State {
        int id;
        int distFromStart;

        public State(int id, int distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }

    private int[] dijkstra(int start, List<int[]>[] graph) {
        int[] distTo = new int[graph.length];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[start] = 0;
        distTo[0] = 0;
        Queue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.distFromStart - b.distFromStart;
        });

        pq.add(new State(start, 0));
        while (!pq.isEmpty()) {
            State cur = pq.poll();
            if (cur.distFromStart > distTo[cur.id]) continue;

            List<int[]> neighbors = graph[cur.id];
            for (int[] neighbor : neighbors) {
                int weight = neighbor[1] + cur.distFromStart;
                if (weight < distTo[neighbor[0]]) {
                    distTo[neighbor[0]] = weight;
                    pq.add(new State(neighbor[0], weight));
                }
            }
        }

        return distTo;
    }
}
