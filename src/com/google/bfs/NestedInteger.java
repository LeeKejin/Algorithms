package com.google.bfs;

import java.util.List;

public interface NestedInteger {
    // Constructor initializes an empty nested list.

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();


    /*
     public int depthSum(List<NestedInteger> nestedList) {
        Queue<NestedInteger> queue = new LinkedList<>();
        for (NestedInteger value : nestedList) {
            queue.add(value);
        }
        int layer = 1;
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger val = queue.poll();
                if(val.getInteger()!=null){
                    res += (val.getInteger() * layer);
                }

                for (NestedInteger next : val.getList()) {
                    queue.add(next);
                }
            }
            layer++;
        }
        return res;
    }
     */

    /*
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Queue<NestedInteger> queue = new LinkedList<>();
        for (NestedInteger node : nestedList) {
            queue.add(node);
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger node = queue.poll();
                if (node.getInteger() != null) {
                    map.putIfAbsent(step, new ArrayList<>());
                    map.get(step).add(node.getInteger());
                }
                for (NestedInteger next : node.getList()) {
                    queue.add(next);
                }
            }
            step++;
        }
        int max = step - 1;
        int sum = 0;
        while (max >= 0) {
            List<Integer> list = map.getOrDefault(max, new ArrayList<>());
            for (int val : list) {
                sum += val * (step - max);
            }
            max--;
        }
        return sum;
    }
     */
}
