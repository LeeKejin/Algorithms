package com.algorithms.sword.means.offer;

import java.util.Stack;

public class CQueue
{
    Stack< Integer > stack = new Stack<>();
    Stack< Integer > tempStack = new Stack<>();

    public CQueue()
    {

    }

    public void appendTail( int value )
    {
        while ( !stack.isEmpty() )
        {
            tempStack.push( stack.pop() );
        }
        stack.push( value );
        while ( !tempStack.isEmpty() )
        {
            stack.push( tempStack.pop() );
        }
    }

    public int deleteHead()
    {
        if ( stack.isEmpty() ) return -1;
        return stack.pop();
    }
}
