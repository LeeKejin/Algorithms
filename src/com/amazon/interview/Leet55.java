package com.amazon.interview;

public class Leet55
{
    public boolean canJump( int[] nums )
    {
        int right = 0;
        for ( int i = 0; i < nums.length; i++ )
        {
            if ( i <= right )
            {
                right = Math.max( right, i + nums[ i ] );
                if ( right >= nums.length - 1 ) return true;
            }
        }
        return false;
    }

    public boolean canJumpSolution1( int[] nums )
    {
        if ( nums.length == 0 ) return true;
        int k = 0;
        for ( int i = 0; i < nums.length; i++ )
        {
            if ( i <= k )
            {
                k = Math.max( i + nums[ i ], k );
            }
            else
            {
                return false;
            }
        }
        return k >= ( nums.length - 1 );
    }
}
