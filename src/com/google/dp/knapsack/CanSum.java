package com.google.dp.knapsack;

import java.util.ArrayList;
import java.util.List;

public class CanSum
{
    public List< Integer > canSum( int sum, int[] nums )
    {
        if ( sum == 0 ) return new ArrayList<>();
        if ( sum < 0 ) return null;
        for ( int i = 0; i < nums.length; i++ )
        {
            List< Integer > res = canSum( sum - nums[ i ], nums );
            if ( res != null )
            {
                res.add( nums[ i ] );
                return res;
            }
        }
        return null;
    }

    public boolean canSumDP( int target, int[] nums )
    {

        boolean[] dp = new boolean[ target + 1 ];
        dp[ 0 ] = true;
        for ( int i = 0; i <= target; i++ )
        {
            if ( dp[ i ] )
            {
                for ( int j = 0; j < nums.length; j++ )
                {
                    if ( nums[ j ] + i <= target )
                    {
                        dp[ nums[ j ] + i ] = true;
                    }

                }
            }

        }

        return dp[ target ];
    }
}
