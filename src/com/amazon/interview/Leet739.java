package com.amazon.interview;

import java.util.Stack;

public class Leet739
{
    public int[] dailyTemperatures( int[] T )
    {
        Stack< Integer > stack = new Stack<>();
        int res[] = new int[ T.length ];
        for ( int i = 0; i < T.length; i++ )
        {

            while ( !stack.isEmpty() && T[ stack.peek() ] < T[ i ] )
            {
                int val = stack.pop();
                res[ val ] = i - val;
            }
            stack.push( i );
        }

        return res;
    }
}
