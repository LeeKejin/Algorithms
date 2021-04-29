package com.algorithms.sword.means.offer;

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
        if ( minStack.isEmpty() || minStack.peek() >= x )
        {
            minStack.push( x );
        }
    }

    public void pop()
    {
        int val = stack.peek();
        if ( val == min() ) minStack.pop();
        stack.pop();
    }

    public int top()
    {
        return stack.peek();
    }

    public int min()
    {
        return minStack.peek();
    }

    public static void main( String[] args )
    {
        MinStack m = new MinStack();
        m.push( -2 );
        m.push( 0 );
        m.push( -3 );
        System.out.println( m.min() );
        m.pop();
        System.out.println( m.top() );
        System.out.println( m.min() );
    }
}
