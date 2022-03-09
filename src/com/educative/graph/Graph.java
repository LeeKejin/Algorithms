package com.educative.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    int vertices; //Total number of vertices in graph
    DoublyLinkedList<Integer> adjacencyList[];

    @SuppressWarnings("unchecked")
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new DoublyLinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new DoublyLinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList[source].insertAtEnd(destination);
//        adjacencyList[destination].insertAtEnd(source);
    }

    public void printGraph() {
        System.out.println(">>Adjacency List of Directed Graph<<");
        for (int i = 0; i < vertices; i++) {
            if (adjacencyList[i] != null) {
                System.out.print("|" + i + "| => ");

                DoublyLinkedList<Integer>.Node temp = adjacencyList[i].getHeadNode();
                while (temp != null) {
                    System.out.print("[" + temp.data + "] -> ");
                    temp = temp.nextNode;
                }
                System.out.println("null");
            } else {

                System.out.println("|" + i + "| => " + "null");
            }
        }
    }

    public static int numEdges(Graph g) {
        int sum = 0;
        for (int i = 0; i < g.vertices; i++) {
            DoublyLinkedList<Integer> list = g.adjacencyList[i];
            DoublyLinkedList<Integer>.Node node = list.headNode;
            while (node != null) {
                sum++;
                node = node.nextNode;
            }
        }
        return sum / 2;
    }

    public static boolean checkPath(Graph g, int source, int destination) {
        if (source == destination) return true;
        java.util.Stack<Integer> stack = new Stack<>();
        stack.push(source);
        boolean visited[] = new boolean[g.vertices];

        while (!stack.isEmpty()) {
            int n = stack.pop();
            visited[n] = true;
            DoublyLinkedList<Integer> list = g.adjacencyList[n];
            DoublyLinkedList<Integer>.Node node = list.headNode;
            while (node != null) {
                if (node.data == destination) return true;
                if (!visited[node.data]) {
                    stack.push(node.data);
                }
                node = node.nextNode;
            }
        }
        return false;
    }

    public static boolean isTree(Graph g) {
        if (!checkOneParent(g)) return false;
        boolean[] visited = new boolean[g.vertices];
        if (detectCycle(g, visited)) return false;
        for (boolean b : visited) {
            if (!b) return false;
        }
        return true;
    }

    private static boolean detectCycle(Graph g, boolean[] visited) {

        for (int i = 0; i < g.vertices; i++) {
            if (!visited[i]) {
                if (dfs(g, visited, i)) return true;
            }
        }
        return false;
    }

    private static boolean dfs(Graph g, boolean[] visited, int i) {
        Stack<Integer> stack = new Stack<>();
        stack.push(i);
        while (!stack.isEmpty()) {
            int n = stack.pop();
            visited[n] = true;
            DoublyLinkedList<Integer> list = g.adjacencyList[n];
            DoublyLinkedList<Integer>.Node node = list.headNode;
            while (node != null) {
                if (visited[node.data]) return true;
                stack.push(node.data);
                node = node.nextNode;
            }
        }
        return false;
    }

    public static boolean checkOneParent(Graph g) {
        boolean[] isOneParent = new boolean[g.vertices];

        for (int i = 0; i < g.vertices; i++) {
            DoublyLinkedList<Integer> list = g.adjacencyList[i];
            DoublyLinkedList<Integer>.Node node = list.headNode;
            while (node != null) {
                if (isOneParent[node.data]) return false;
                isOneParent[node.data] = true;
                node = node.nextNode;
            }
        }
        for (int i = 0; i < g.vertices; i++) {
            if (i == 0 && isOneParent[i]) return false;
            if (i != 0 && !isOneParent[i]) return false;
        }
        return true;
    }

    public static int findMin(Graph g, int source, int destination) {
        if (destination == source) return 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        boolean visited[] = new boolean[g.vertices];
        int dest[] = new int[g.vertices];

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            visited[cur] = true;

            DoublyLinkedList<Integer>.Node node = g.adjacencyList[cur].headNode;

            while (node != null) {
                if (!visited[node.data]) {
                    dest[node.data] = dest[cur] + 1;
                    if (destination == node.data) return dest[node.data];
                    queue.add(node.data);
                }
                node = node.nextNode;
            }
        }

        return -1;
    }

    public static void removeEdge(Graph g, int source, int destination) {
        if (g.adjacencyList[source] == null) return;
        DoublyLinkedList<Integer>.Node node = g.adjacencyList[source].headNode;

        while (node != null) {
            if (node.data == destination) {
                DoublyLinkedList<Integer>.Node next = node.nextNode;
                DoublyLinkedList<Integer>.Node prev = node.prevNode;
                if (prev == null) {
                    g.adjacencyList[source].headNode = next;
                } else {
                    prev.nextNode = next;
                }
                if (next == null) {
                    g.adjacencyList[source].tailNode = prev;
                } else {
                    next.prevNode = prev;
                }

                break;
            }
            node = node.nextNode;
        }
    }
}
