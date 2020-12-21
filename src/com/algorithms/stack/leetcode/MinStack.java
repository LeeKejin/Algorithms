package com.algorithms.stack.leetcode;

import java.util.Stack;

public class MinStack
{
    Stack< Integer > stack = new Stack<>();
    Stack< Integer > minStack = new Stack<>();

    public MinStack()
    {

    }

    public void push( int x )
    {
        stack.push( x );
        if ( minStack.isEmpty() )
        {
            minStack.push( x );
        }
        else
        {
            int val = minStack.peek();
            int min = Math.min( x, val );
            minStack.push( min );
        }
    }

    public void pop()
    {
        stack.pop();
        minStack.pop();
    }

    public int top()
    {
        return stack.peek();
    }

    public int getMin()
    {
        return minStack.peek();
    }

    public static void main( String[] args )
    {
        MinStack ms = new MinStack();
        ms.push( 2 );
        ms.push( 0 );
        ms.push( 3 );
        ms.push( 0 );
        System.out.println( ms.getMin() );
        ms.pop();
        System.out.println( ms.getMin() );
        ms.pop();
        System.out.println( ms.getMin() );
        ms.pop();
        System.out.println( ms.getMin() );
    }
}
