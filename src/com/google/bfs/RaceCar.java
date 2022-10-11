package com.google.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//O(2^N)
public class RaceCar {
    class State {
        int pos;
        int speed;

        public State(int pos, int speed) {
            this.pos = pos;
            this.speed = speed;
        }
    }


    public int racecar(int target) {
        if (target == 0) return 0;
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, 1));
        int step = 0;
        Set<String> visited = new HashSet<>();
        visited.add(0 + "," + 1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                State state = queue.poll();
                if (state.pos == target) return step;
                //A
                int nextP = state.pos + state.speed;
                int nextS = state.speed * 2;
                if (!visited.contains(nextP + "," + nextS) && Math.abs(target - nextP) < target) {
                    queue.add(new State(nextP, nextS));
                    visited.add(nextP + "," + nextS);
                }
                //R
                nextP = state.pos;
                nextS = state.speed > 0 ? -1 : 1;
                if (!visited.contains(nextP + "," + nextS) && Math.abs(target - nextP) < target) {
                    queue.add(new State(nextP, nextS));
                    visited.add(nextP + "," + nextS);
                }
            }
            step++;
        }
        return -1;


    }
}
