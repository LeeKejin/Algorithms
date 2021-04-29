package com.amazon.interview;

import java.util.Arrays;
import java.util.Stack;

public class Leet503
{
    public int[] nextGreaterElements( int[] nums )
    {
        Stack< Integer > stack = new Stack<>();
        int arr[] = new int[ nums.length * 2 ];
        int res[] = new int[ nums.length * 2 ];
        for ( int i = 0; i < arr.length; i++ )
        {
            arr[ i ] = nums[ i % nums.length ];
        }
        for ( int i = 0; i < arr.length; i++ )
        {
            while ( !stack.isEmpty() && arr[ stack.peek() ] < arr[ i ] )
            {
                res[ stack.peek() ] = arr[ i ];
                stack.pop();
            }
            stack.push( i );
        }
        while ( !stack.isEmpty() )
        {
            res[ stack.pop() ] = -1;
        }
        return Arrays.copyOf( res, nums.length );
    }
}
