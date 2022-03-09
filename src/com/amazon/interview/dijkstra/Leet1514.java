package com.amazon.interview.dijkstra;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode-cn.com/problems/path-with-maximum-probability/solution/dijkstra-suan-fa-xiang-jie-by-labuladong-8zhv/
public class Leet1514 {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<double[]>[] graph = new LinkedList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            double weight = succProb[i];
            graph[from].add(new double[]{to, weight});
            graph[to].add(new double[]{from, weight});
        }

        return dijkstra(start, end, graph);

    }

    class State {
        int id;
        double probFromStart;

        public State(int id, double probFromStart) {
            this.id = id;
            this.probFromStart = probFromStart;
        }
    }

    private double dijkstra(int start, int end, List<double[]>[] graph) {
        double prob[] = new double[graph.length];
        Arrays.fill(prob, -1);
        prob[start] = 1;
        PriorityQueue<State> queue = new PriorityQueue<>((s1, s2) -> Double.compare(s2.probFromStart, s1.probFromStart));
        queue.add(new State(start, 1));
        while (!queue.isEmpty()) {
            State cur = queue.poll();
            if (cur.id == end) return cur.probFromStart;
            if (cur.probFromStart < prob[cur.id]) continue;

            List<double[]> neighbors = graph[cur.id];
            for (double[] neighbor : neighbors) {
                double newWeight = neighbor[1] * prob[cur.id];
                if (newWeight > prob[(int) neighbor[0]]) {
                    prob[(int) neighbor[0]] = newWeight;
                    queue.add(new State((int) neighbor[0], newWeight));
                }
            }

        }
        return 0;
    }
}
