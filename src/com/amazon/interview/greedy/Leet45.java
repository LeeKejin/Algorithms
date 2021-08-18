package com.amazon.interview.greedy;

public class Leet45
{
    public int jump( int[] nums )
    {
        int res = 0;
        int start = 0;
        int end = 1;
        while ( end < nums.length )
        {
            int max = 0;
            for ( int i = start; i < end; i++ )
            {
                max = Math.max( max, i + nums[ i ] );
            }
            start = end;
            end = max + 1;
            res++;
        }
        return res;
    }

    public int jump1( int[] nums )
    {
        int res = 0;
        int end = 0;
        int max = 0;
        for ( int i = 0; i < nums.length - 1; i++ )
        {

            max = Math.max( max, i + nums[ i ] );
            if ( i == end )
            {
                res++;
                end = max;
            }
        }
        return res;
    }

    public int jump2( int[] nums )
    {

        int max = 0;
        int res = 0;
        int end = 0;
        for ( int i = 0; i < nums.length - 1; i++ )
        {
            max = Math.max( max, i + nums[ i ] );
            if ( i == end )
            {
                res++;
                end = max;
                if ( end >= nums.length - 1 ) return res;
            }
        }
        return res;
    }
}
