package com.algorithms.dynamicprogramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leet403
{
    public boolean canCross( int[] stones )
    {
        Map< Integer, Set< Integer > > map = new HashMap<>();
        for ( int i = 0; i < stones.length; i++ )
        {
            if ( i == 0 )
            {
                Set< Integer > set = new HashSet<>();
                set.add( 0 );
                map.put( stones[ i ], set );
            }
            else
            {
                map.put( stones[ i ], new HashSet<>() );
            }
        }

        for ( int i = 1; i < stones.length; i++ )
        {
            Set< Integer > steps = new HashSet<>();

            for ( int j = 0; j < i; j++ )
            {
                int gap = Math.abs( stones[ i ] - stones[ j ] );
                Set< Integer > list = map.get( stones[ j ] );
                for ( int step : list )
                {
                    if ( step + 1 == gap )
                    {
                        steps.add( step + 1 );
                    }
                    else if ( step == gap )
                    {
                        steps.add( step );
                    }
                    else if ( step - 1 == gap )
                    {
                        steps.add( step - 1 );
                    }
                }
            }
            map.get( stones[ i ] ).addAll( steps );

        }
        return !map.get( stones[ stones.length - 1 ] ).isEmpty();
    }
}
