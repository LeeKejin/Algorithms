package com.google.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxHeap {
    List<Integer> list = new ArrayList<>();

    int getParent(int index) {
        return (index - 1) / 2;
    }

    int getLeftChild(int index) {
        return index * 2 + 1;
    }

    int getRightChild(int index) {
        return index * 2 + 2;
    }

    public void add(int val) {
        list.add(val);
        shiftUp(list.size() - 1);
    }

    private void shiftUp(int index) {
        if (index <= 0) return;
        int parent = getParent(index);
        if (list.get(parent) > list.get(index)) {
            return;
        }
        swap(parent, index);
        shiftUp(parent);
    }

    private void swap(int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    int getMax() {
        int max = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        shiftDown(0);
        return max;
    }

    private void shiftDown(int index) {
        if (index >= list.size()) return;
        int left = getLeftChild(index);
        int right = getRightChild(index);
        if (left >= list.size()) return;

        if ((left < list.size() && list.get(left) > list.get(index))
                && (right < list.size() && list.get(right) > list.get(index))) {
            if (list.get(left) > list.get(right)) {
                swap(left, index);
                index = left;
            } else {
                swap(right, index);
                index = right;
            }
            shiftDown(index);
        } else if (left < list.size() && list.get(left) > list.get(index)) {
            swap(left, index);
            index = left;
            shiftDown(index);
        }
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();

        List<Integer> list = Arrays.asList(4, 9, 6, 5, -2, 7, 1);
        for (int i : list) {
            maxHeap.add(i);
        }
        System.out.println(maxHeap.list);

        for (int i = 0; i < 7; i++) {
            System.out.println(maxHeap.getMax());
        }
    }
}
