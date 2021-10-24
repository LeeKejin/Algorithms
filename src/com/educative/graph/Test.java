package com.educative.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
    int count = 0;

    public static void main(String[] args) {
//        Graph graph = new Graph(5);
        Graph g2 = new Graph(5);
        g2.addEdge(0, 1);
        g2.addEdge(0, 4);
        g2.addEdge(1, 2);
        g2.addEdge(3, 4);
        g2.printGraph();

        System.out.println(bfs(g2));
    }

    public static String bfs(Graph g) {
        String res = "";
        boolean visited[] = new boolean[g.vertices];
        for (int i = 0; i < g.vertices; i++) {
            if (!visited[i]) {
                res += bfs(i, g, visited);
            }
        }
        return res;
    }

    private static String bfs(int i, Graph g, boolean visited[]) {
        String res = "";
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        while (!queue.isEmpty()) {
            int n = queue.poll();
            visited[n] = true;
            res += n;
            DoublyLinkedList list = g.adjacencyList[n];
            DoublyLinkedList.Node node = list.headNode;
            while (node != null) {
                if (!visited[(int) node.data])
                    queue.add((int) node.data);
                node = node.nextNode;
            }
        }
        return res;
    }
}
