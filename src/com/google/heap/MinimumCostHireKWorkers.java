package com.google.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumCostHireKWorkers {
    class State {
        int wage;
        double prec;
        int quality;

        public State(int wage, Double prec, int quality) {
            this.wage = wage;
            this.prec = prec;
            this.quality = quality;
        }
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        List<State> list = new ArrayList<>();
        for (int i = 0; i < quality.length; i++) {
            State state = new State(wage[i], wage[i] * 1.0 / quality[i], quality[i]);
            list.add(state);
        }
        Collections.sort(list, (a, b) -> (Double.compare(a.prec, b.prec)));
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        int sum = 0;
        double res = Integer.MAX_VALUE;
        for (State state : list) {
            sum += state.quality;
            queue.add(state.quality);
            if (queue.size() > k) {
                sum -= queue.poll();
            }
            if (queue.size() == k) {
                res = Math.min(sum * state.prec, res);
            }
        }
        return res;
    }
}
