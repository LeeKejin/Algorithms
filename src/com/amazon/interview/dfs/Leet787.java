package com.amazon.interview.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
V^2*log(V)
V is number of cities
 */
public class Leet787 {
    class State {
        int id;
        int price;

        public State(int id, int price) {
            this.id = id;
            this.price = price;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<State>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] flight : flights) {
            graph[flight[0]].add(new State(flight[1], flight[2]));
        }
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(src, 0));
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.MAX_VALUE;
        }
        arr[src] = 0;

        while (!queue.isEmpty() && k + 1 > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                State cur = queue.poll();

                List<State> neighbors = graph[cur.id];
                for (State neighbor : neighbors) {
                    if (arr[neighbor.id] > cur.price + neighbor.price) {
                        arr[neighbor.id] = cur.price + neighbor.price;
                        queue.add(new State(neighbor.id, arr[neighbor.id]));
                    }
                }
            }

            k--;
        }
        return arr[dst] == Integer.MAX_VALUE ? -1 : arr[dst];
    }
}
