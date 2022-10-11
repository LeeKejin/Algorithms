package com.crackingcodeinterview.chapter3;


import java.util.Stack;

public class MyQueue_3_4 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public MyQueue_3_4() {

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack2.push(x);
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {

        return stack2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return stack2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack2.isEmpty();
    }
}
