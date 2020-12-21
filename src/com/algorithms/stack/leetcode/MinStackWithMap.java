package com.algorithms.stack.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MinStackWithMap
{
    Stack< Map< Integer, Integer > > stack = new Stack<>();

    public void push( int x )
    {
        if ( stack.isEmpty() )
        {
            Map< Integer, Integer > map = new HashMap<>();
            map.put( x, x );
            stack.push( map );
        }
        else
        {
            Map< Integer, Integer > existedMap = stack.peek();
            int min = 0;
            for ( int key : existedMap.keySet() )
            {
                min = Math.min( existedMap.get( key ), x );
            }
            Map< Integer, Integer > map = new HashMap<>();
            map.put( x, min );
            stack.push( map );
        }
    }

    public void pop()
    {
        stack.pop();
    }

    public int top()
    {
        Map< Integer, Integer > existedMap = stack.peek();
        int val = 0;
        for ( int key : existedMap.keySet() )
        {
            val = key;
        }
        return val;
    }

    public int getMin()
    {
        Map< Integer, Integer > existedMap = stack.peek();
        int val = 0;
        for ( int key : existedMap.keySet() )
        {
            val = existedMap.get( key );
        }
        return val;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

