package com.algorithms.collection.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leet202
{
    public boolean isHappy( int n )
    {
        Set< Integer > set = new HashSet<>();
        while ( n != 1 )
        {
            n = calculate( n );
            if ( set.contains( n ) )
            {
                return false;
            }
            else
            {
                set.add( n );
            }
        }
        return true;
    }

    private int calculate( int n )
    {
        int sum = 0;
        while ( n != 0 )
        {
            sum += Math.pow( n % 10, 2 );
            n = n / 10;
        }
        return sum;
    }
}
