package com.amazon.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Leet496
{
    public int[] nextGreaterElement( int[] nums1, int[] nums2 )
    {
        Map< Integer, Integer > map = new HashMap<>();
        Stack< Integer > stack = new Stack<>();
        for ( int num : nums2 )
        {
            while ( !stack.empty() && num > stack.peek() )
            {
                map.put( stack.pop(), num );
            }

            stack.push( num );

        }
        while ( !stack.isEmpty() )
        {
            int val = stack.pop();
            map.put( val, -1 );
        }
        int[] res = new int[ nums1.length ];
        for ( int i = 0; i < nums1.length; i++ )
        {
            res[ i ] = map.get( nums1[ i ] );
        }
        return res;
    }
}
