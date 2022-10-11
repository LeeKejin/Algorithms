package com.google.greedy;

import java.util.*;

//O(NMlog(NM))
public class CampusBikes {
    class State {
        int workerX;
        int workerY;
        int bikeX;
        int bikeY;
        int d;
        int index;
        int bIndex;

        public State(int workerX, int workerY, int bikeX, int bikeY, int index, int bIndex) {
            this.workerX = workerX;
            this.workerY = workerY;
            this.bikeX = bikeX;
            this.bikeY = bikeY;
            this.d = Math.abs(workerX - bikeX) + Math.abs(workerY - bikeY);
            this.index = index;
            this.bIndex = bIndex;
        }
    }

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        List<State> states = new ArrayList<>();
        for (int i = 0; i < workers.length; i++) {
            int[] worker = workers[i];
            int workerX = worker[0];
            int workerY = worker[1];

            for (int j = 0; j < bikes.length; j++) {
                states.add(new State(workerX, workerY, bikes[j][0], bikes[j][1], i, j));
            }


        }
        Collections.sort(states, (a, b) -> a.d == b.d ? a.index - b.index : a.d - b.d);
        boolean[][] visited = new boolean[1001][1001];
        int k = 0;
        int res[][] = new int[workers.length][2];
        for (int i = 0; i < states.size(); i++) {
            State state = states.get(i);
            if (!visited[state.workerX][state.workerY] && !visited[state.bikeX][state.bikeY]) {
                res[k][0] = state.index;
                res[k][1] = state.bIndex;
                k++;
                visited[state.workerX][state.workerY] = true;
                visited[state.bikeX][state.bikeY] = true;
            }
            if (k == workers.length) break;
        }

        Arrays.sort(res, (a, b) -> (a[0] - b[0]));
        int arr[] = new int[workers.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res[i][1];
        }
        return arr;
    }

    /*
    bucket sort
    Here, NN is the number of workers, M is the number of bikes,
    and K is the maximum possible Manhattan distance of a worker/bike pair.
    In this problem, K equals 1998.
     Time complexity: O(NM + K)
     */
    /*
    class Solution {
        // Function to return the Manhattan distance
        int findDistance(int[] worker, int[] bike) {
            return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
        }

        public int[] assignBikesBucket(int[][] workers, int[][] bikes) {
            int minDis = Integer.MAX_VALUE;
            // Stores the list of (worker, bike) pairs corresponding to its distance
            Map<Integer, List<Pair<Integer, Integer>>> disToPairs = new HashMap();

            // Add the (worker, bike) pair corresponding to its distance list
            for (int worker = 0; worker < workers.length; worker++) {
                for (int bike = 0; bike < bikes.length; bike++) {
                    int distance = findDistance(workers[worker], bikes[bike]);

                    disToPairs.putIfAbsent(distance, new ArrayList<>());

                    disToPairs.get(distance).add(new Pair(worker, bike));
                    minDis = Math.min(minDis, distance);
                }
            }

            int currDis = minDis;
            // Initialize all values to false, to signify no bikes have been taken
            boolean bikeStatus[] = new boolean[bikes.length];

            int workerStatus[] = new int[workers.length];
            // Initialize all index to -1, to mark all the workers available
            Arrays.fill(workerStatus, -1);
            // Keep track of how many worker-bike pairs have been made
            int pairCount = 0;

            // Until all workers have not been assigned a bike
            while (pairCount != workers.length) {
                if (!disToPairs.containsKey(currDis)) {
                    currDis++;
                    continue;
                }

                for (Pair<Integer, Integer> pair : disToPairs.get(currDis)) {
                    int worker = pair.getKey();
                    int bike = pair.getValue();

                    if (workerStatus[worker] == -1 && !bikeStatus[bike]) {
                        // If both worker and bike are free, assign them to each other
                        bikeStatus[bike] = true;
                        workerStatus[worker] = bike;
                        pairCount++;
                    }
                }
                currDis++;
            }

            return workerStatus;
        }
    }*/
}
