package com.crackingcodeinterview.chapter3;


import java.util.*;

public class StackOfPlates_3_3 {
    List<Stack> list = new ArrayList<>();
    int cap;

    public StackOfPlates_3_3(int cap) {
        this.cap = cap;

    }

    public void push(int val) {
        if (cap == 0) return;
        if (list.isEmpty() || list.get(list.size() - 1).size() == cap) {
            list.add(new Stack());
        }
        list.get(list.size() - 1).push(val);
    }

    public int pop() {
        if (list.isEmpty()) return -1;
        int val = (int) list.get(list.size() - 1).pop();
        if (list.get(list.size() - 1).isEmpty()) list.remove(list.size() - 1);
        return val;
    }

    public int popAt(int index) {
        if (list.size() <= index) return -1;
        int val = (int) list.get(index).pop();
        if (list.get(index).isEmpty()) list.remove(index);
        return val;
    }
}
