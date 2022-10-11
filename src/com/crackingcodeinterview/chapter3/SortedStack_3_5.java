package com.crackingcodeinterview.chapter3;

import java.util.Stack;

public class SortedStack_3_5 {

    public SortedStack_3_5() {

    }

    Stack<Integer> stack = new Stack<>();

    public void push(int val) {
        Stack<Integer> tmp = new Stack<>();
        while (!stack.isEmpty() && stack.peek() < val) {
            tmp.push(stack.pop());
        }
        stack.push(val);
        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }

        //sort(val)
    }

    public void pop() {
        if (stack.isEmpty()) return;
        stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

//    private void sort(int val) {
//        if (stack.isEmpty()||val < stack.peek()){
//            stack.push(val);
//            return;
//        }else{
//            int temp = stack.pop();
//            sort(val);
//            stack.push(temp);
//        }
//    }


}
