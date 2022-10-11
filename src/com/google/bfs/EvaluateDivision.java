package com.google.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
//equation
//evaulation
//divide
//division
public class EvaluateDivision {
    /*
    Time Complexity: \mathcal{O}\big( (M+N) \cdot \log^{*}N\big)O((M+N)⋅log
∗
 N).

First of all, we iterate through each input equation and invoke union() upon it. As a result, the overall time complexity of this step is \mathcal{O}\big(N \cdot \log^{*}N\big)O(N⋅log
∗
 N).

As the second step, we then evaluate the query one by one. For each evaluation, we invoke the find() function at most twice. Therefore, the overall time complexity of this step is \mathcal{O}\big(M \cdot \log^{*}N\big)O(M⋅log
∗
 N).

To sum up, the total time complexity of the algorithm is \mathcal{O}\big( (M+N) \cdot \log^{*}N\big)O((M+N)⋅log
∗
 N).

Note, as compared to the DFS/BFS search approach, Union-Find data structure is more efficient for the repetitive/redundant query scenario.

Once we evaluate a query with Union-Find, all the subsequent repetitive queries or any query that has the overlapping with the previous query in terms of variable group could be evaluated in constant time. For instance, in the above example, once the query of \frac{a}{c}
c
a
​
  is evaluated, if later we want to evaluate \frac{a}{b}
b
a
​
 , we could instantly obtain the states of variables a and b without triggering the chain update again. While for DFS/BFS approaches, the cost of evaluating each query is independent for each other.
     */
    class UnionClass {
        int parents[];
        double weight[];

        public UnionClass(int n) {
            parents = new int[n];
            weight = new double[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                weight[i] = 1.0;
            }
        }

        void merge(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parents[rootX] = rootY;
                // weight[y] * value ---> y to RootY distance
                //weight[rootX]* weight[x] ---->rootX to RootY distance
                weight[rootX] = weight[y] * value / weight[x];
            }
        }

        private int find(int x) {
            if (x != parents[x]) {
                int origin = parents[x];
                parents[x] = find(origin);
                weight[x] *= weight[origin];//compress path  point x to new root = point x to origin parent * origin parent to new  parent
            }
            return parents[x];
        }

        boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size() * 2;
        UnionClass unionClass = new UnionClass(n);
        int index = 0;
        Map<String, Integer> map = new HashMap<>();
        int i = 0;
        for (List<String> equ : equations) {
            if (!map.containsKey(equ.get(0))) {
                map.put(equ.get(0), index);
                index++;
            }
            if (!map.containsKey(equ.get(1))) {
                map.put(equ.get(1), index);
                index++;
            }
            unionClass.merge(map.get(equ.get(0)), map.get(equ.get(1)), values[i]);
            i++;
        }
        double res[] = new double[queries.size()];
        for (int j = 0; j < queries.size(); j++) {
            List<String> query = queries.get(j);
            String x = query.get(0);
            String y = query.get(1);
            if (!map.containsKey(x) || !map.containsKey(y) || !unionClass
                    .isConnected(map.get(x), map.get(y))) {
                res[j] = -1.0;
                continue;
            } else {
                res[j] = unionClass.weight[map.get(x)] / unionClass.weight[map.get(y)];
            }
        }
        return res;
    }

    class State {
        String id;
        double weight;

        public State(String id, double weight) {
            this.id = id;
            this.weight = weight;
        }
    }

    Map<String[], Double> memo = new HashMap<>();

    /*
    O(M*N) let N be the number of input equations and M be the number of queries.

     */
    public double[] calcEquationBFS(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<State>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String v1 = equations.get(i).get(0);
            String v2 = equations.get(i).get(1);
            double w = values[i];
            map.putIfAbsent(v1, new ArrayList<>());
            map.putIfAbsent(v2, new ArrayList<>());

            map.get(v1).add(new State(v2, w));
            map.get(v2).add(new State(v1, 1.0 / (w * 1.0)));
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String v1 = queries.get(i).get(0);
            String v2 = queries.get(i).get(1);
            if (!map.containsKey(v1) || !map.containsKey(v2)) {
                res[i] = -1;
                continue;
            }
            double val = find(v1, v2, map);
            res[i] = val;
        }
        return res;
    }

    private double find(String v1, String v2, Map<String, List<State>> map) {
        if (memo.containsKey(new String[]{v1, v2})) return memo.get(new String[]{v1, v2});
        Queue<State> queue = new LinkedList<>();
        for (State state : map.get(v1)) {
            queue.add(state);
        }

        Set<String> set = new HashSet<>();
        while (!queue.isEmpty()) {
            State cur = queue.poll();
            if (set.contains(cur.id)) continue;
            set.add(cur.id);
            if (cur.id.equals(v2)) return cur.weight;
            for (State next : map.get(cur.id)) {
                double w = cur.weight * next.weight;
                queue.add(new State(next.id, w));
                memo.put(new String[]{cur.id, next.id}, w);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        EvaluateDivision test = new EvaluateDivision();
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("a", "b"));
        list.add(Arrays.asList("d", "c"));
        list.add(Arrays.asList("a", "d"));

        List<List<String>> list1 = new ArrayList<>();
        list1.add(Arrays.asList("b", "c"));

        test.calcEquationBFS(list, new double[]{3.0, 4, 6}, list1);
    }
}
