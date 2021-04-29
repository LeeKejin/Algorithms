package com.algorithms.sword.means.offer;

import java.util.Stack;

public class MaxStack
{
    Stack< Integer > stack = new Stack<>();
    Stack< Integer > maxStack = new Stack<>();

    public MaxStack()
    {

    }

    public void push( int x )
    {
        stack.push( x );
        if ( maxStack.isEmpty() || maxStack.peek() < x )
        {
            maxStack.push( x );
        }
        else
        {
            maxStack.push( maxStack.peek() );
        }
    }

    public int pop()
    {
        maxStack.pop();
        return stack.pop();
    }

    public int top()
    {
        return stack.peek();
    }

    public int peekMax()
    {
        return maxStack.peek();
    }

    public int popMax()
    {
        Stack< Integer > temp = new Stack<>();
        while ( !maxStack.peek().equals( stack.peek() ) )
        {
            temp.push( this.pop() );
        }
        int max = this.pop();
        while ( !temp.isEmpty() )
        {
            this.push( temp.pop() );
        }
        return max;
    }
}
