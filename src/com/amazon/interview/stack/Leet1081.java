package com.amazon.interview.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Leet1081
{
    public String smallestSubsequence( String s )
    {
        Stack< Character > stack = new Stack<>();
        Map< Character, Integer > map = new HashMap<>();
        for ( char c : s.toCharArray() )
        {
            map.put( c, map.getOrDefault( c, 0 ) + 1 );
        }
        for ( char c : s.toCharArray() )
        {
            if ( stack.contains( c ) )
            {
                map.put( c, map.get( c ) - 1 );
                continue;
            }
            while ( !stack.isEmpty() && stack.peek() > c && map.get( stack.peek() ) > 0 )
            {
                stack.pop();
            }
            stack.push( c );
            map.put( c, map.get( c ) - 1 );
        }
        String s1 = "";
        while ( !stack.isEmpty() )
        {
            s1 = stack.pop() + s1;
        }
        return s1;
    }
}
