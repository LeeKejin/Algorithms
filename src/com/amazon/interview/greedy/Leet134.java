package com.amazon.interview.greedy;

import java.util.ArrayList;
import java.util.List;

public class Leet134
{
    public int canCompleteCircuit( int[] gas, int[] cost )
    {

        List< Integer > pos = new ArrayList<>();
        for ( int i = 0; i < cost.length; i++ )
        {
            if ( gas[ i ] >= cost[ i ] )
            {

                pos.add( i );
            }

        }

        for ( int index : pos )
        {
            int sum = 0;
            for ( int i = index; i < gas.length + index; i++ )
            {
                sum += gas[ i % gas.length ];
                sum -= cost[ i % gas.length ];
                if ( sum < 0 ) break;
            }
            if ( sum >= 0 ) return index;
        }
        return -1;
    }

    public int canCompleteCircuit1( int[] gas, int[] cost )
    {
        int start = 0;
        int sum = 0;
        int totalSum = 0;
        for ( int i = 0; i < gas.length; i++ )
        {
            totalSum += gas[ i ] - cost[ i ];
            sum += gas[ i ] - cost[ i ];
            if ( sum < 0 )
            {
                sum = 0;
                start = i + 1;
            }
        }
        return totalSum >= 0 ? start : -1;
    }

}
