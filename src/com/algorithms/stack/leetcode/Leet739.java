package com.algorithms.stack.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Leet739
{
    public int[] dailyTemperatures( int[] T )
    {
        Stack< Map< Integer, Integer > > stack = new Stack<>();
        int[] results = new int[ T.length ];

        for ( int i = 0; i < T.length; i++ )
        {
            Map< Integer, Integer > map = new HashMap<>();
            map.put( T[ i ], i );
            if ( stack.isEmpty() )
            {
                stack.push( map );
            }
            else
            {
                while ( !stack.isEmpty() )
                {
                    Map< Integer, Integer > existedMap = stack.peek();
                    int key = getKey( existedMap );
                    int index = existedMap.get( key );
                    if ( key < T[ i ] )
                    {
                        stack.pop();
                        results[ index ] = i - index;
                    }
                    else
                    {
                        break;
                    }
                }
                stack.push( map );

            }
        }
        while ( !stack.isEmpty() )
        {
            Map< Integer, Integer > existedMap = stack.pop();
            int key = getKey( existedMap );
            int index = existedMap.get( key );
            results[ index ] = 0;
        }
        return results;
    }

    private int getKey( Map< Integer, Integer > existedMap )
    {
        for ( int key : existedMap.keySet() )
        {
            return key;
        }
        return -1;
    }
}
