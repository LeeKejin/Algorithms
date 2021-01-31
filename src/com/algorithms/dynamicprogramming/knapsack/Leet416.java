package com.algorithms.dynamicprogramming.knapsack;

import java.util.HashMap;
import java.util.Map;

public class Leet416
{
    Map< Integer, Boolean > map = new HashMap<>();

    public boolean canPartition( int[] nums )
    {
        if ( nums.length == 0 || nums.length == 1 ) return false;
        int sum = 0;
        for ( int i = 0; i < nums.length; i++ )
        {
            sum += nums[ i ];
        }
        if ( sum % 2 != 0 ) return false;
        int val = sum / 2;
        return calculate( nums, val, nums.length - 1 );

    }

    private boolean calculate( int[] nums, int val, int index )
    {
        if ( val == 0 ) return true;
        if ( val < 0 || index < 0 ) return false;

        if ( !map.containsKey( val - nums[ index ] ) )
        {
            boolean b = calculate( nums, val - nums[ index ], index - 1 );
            map.put( val - nums[ index ], b );

        }
        if ( !map.containsKey( val ) )
        {
            boolean b = calculate( nums, val, index - 1 );
            map.put( val, b );
        }
        return map.get( val ) || map.get( val - nums[ index ] );
    }

    public boolean canPartitionDP( int[] nums )
    {
        if ( nums.length == 0 || nums.length == 1 ) return false;

        int sum = 0;
        for ( int i = 0; i < nums.length; i++ )
        {
            sum += nums[ i ];
        }
        if ( sum % 2 != 0 ) return false;
        sum = sum / 2;
        boolean[] dp = new boolean[ sum + 1 ];
        for ( int i = 0; i <= sum; i++ )
            dp[ i ] = ( nums[ 0 ] == i );

        for ( int i = 1; i < nums.length; i++ )
        {
            for ( int j = sum; j >= nums[ i ]; j-- )
            {
                dp[ j ] = dp[ j ] || dp[ j - nums[ i ] ];
            }
        }
        return dp[ sum ];
    }

    public boolean canPartitionUnderstandableSolution( int[] nums )
    {
        if ( nums.length <= 1 ) return false;
        int sum = 0;
        for ( int i : nums )
        {
            sum += i;
        }
        if ( sum % 2 != 0 ) return false;
        boolean dp[] = new boolean[ sum + 1 ];
        dp[ nums[ 0 ] ] = true;
        boolean temp[] = new boolean[ sum + 1 ];
        for ( int i = 1; i < nums.length; i++ )
        {
            for ( int j = 0; j <= sum; j++ )
            {
                if ( dp[ j ] )
                {
                    temp[ nums[ i ] + j ] = true;
                }

            }
            for ( int j = 0; j <= sum; j++ )
            {
                if ( temp[ j ] == true ) dp[ j ] = true;
            }
        }

        return dp[ sum / 2 ];
    }

}
