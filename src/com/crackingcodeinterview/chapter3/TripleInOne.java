package com.crackingcodeinterview.chapter3;

public class TripleInOne {
    int arr[];
    int stackSize;
    int end0;
    int end1;
    int end2;

    public TripleInOne(int stackSize) {
        arr = new int[stackSize * 3];
        this.stackSize = stackSize;
        end0 = -1;
        end1 = -1;
        end2 = -1;
    }

    public void push(int stackNum, int value) {
        if (stackNum == 0) {
            if (end0 == stackSize - 1) return;
            end0++;
            arr[end0] = value;
        }
        if (stackNum == 1) {
            if (end1 == 2 * stackSize - 1) return;
            if (end1 == -1) end1 = stackSize - 1;
            end1++;
            arr[end1] = value;
        }
        if (stackNum == 2) {
            if (end2 == 3 * stackSize - 1) return;
            if (end2 == -1) end2 = stackSize * 2 - 1;
            end2++;
            arr[end2] = value;
        }
    }

    public int pop(int stackNum) {
        if (stackNum == 0) {
            if (end0 == -1) return -1;

            int val = arr[end0];
            end0--;
            return val;
        }
        if (stackNum == 1) {
            if (end1 == -1) return -1;

            int val = arr[end1];
            end1--;
            if (end1 == stackSize - 1) end1 = -1;
            return val;
        }


        if (end2 == -1) return -1;
        int val = arr[end2];
        end2--;
        if (end2 == 2 * stackSize - 1) end2 = -1;
        return val;

    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) return -1;
        if (stackNum == 0) {
            return arr[end0];
        }
        if (stackNum == 1) return arr[end1];
        return arr[end2];
    }


    public boolean isEmpty(int stackNum) {
        if (stackNum == 0) return end0 == -1;
        if (stackNum == 1) return end1 == -1;
        return end2 == -1;
    }

    public static void main(String[] args) {
        TripleInOne tripleInOne = new TripleInOne(2);
        tripleInOne.push(0, 1);
        tripleInOne.push(0, 2);
        tripleInOne.push(0, 3);
        tripleInOne.pop(0);
        tripleInOne.pop(0);
        tripleInOne.pop(0);
        tripleInOne.peek(0);
    }
}
