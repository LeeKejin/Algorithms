package com.amazon.interview.floyed;

public class FloydWarshell {

    void detectNegativeEdge(int[][] cost) {
        for (int k = 0; k < cost.length; k++) {
            for (int i = 0; i < cost.length; i++) {
                for (int j = 0; j < cost.length; j++) {
                    if (cost[i][k] != Integer.MAX_VALUE && cost[k][j] != Integer.MAX_VALUE) {
                        int sum = cost[i][k] + cost[k][j];
                        cost[i][j] = Math.min(sum, cost[i][j]);
                    }
                }
            }
//                if (cost[i][i] < 0) {
//                    System.out.println("Negative Weight Cycle Found at " + i);
//                }
        }
        System.out.println(cost);
    }


    public static void main(String[] args) {
        int adjMatrix[][] =
                {
                        {0, 1, 12, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
                        {Integer.MAX_VALUE, 0, 9, 3, Integer.MAX_VALUE, Integer.MAX_VALUE},
                        {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 5, Integer.MAX_VALUE},
                        {Integer.MAX_VALUE, Integer.MAX_VALUE, 4, 0, 13, 15},
                        {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 4},
                        {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
                };
        FloydWarshell floydWarshell = new FloydWarshell();
        floydWarshell.detectNegativeEdge(adjMatrix);
    }
}
