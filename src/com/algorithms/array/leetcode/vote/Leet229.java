package com.algorithms.array.leetcode.vote;

import java.util.ArrayList;
import java.util.List;

public class Leet229
{
    public List< Integer > majorityElement( int[] nums )
    {
        List< Integer > res = new ArrayList<>();
        if ( nums.length == 0 ) return res;
        if ( nums.length == 1 )
        {
            res.add( nums[ 0 ] );
            return res;
        }
        int v1 = nums[ 0 ];
        int v2 = nums[ 0 ];

        int c1 = 0;
        int c2 = 0;

        for ( int i = 0; i < nums.length; i++ )
        {
            if ( v1 == nums[ i ] )
            {
                c1++;
                continue;
            }
            if ( v2 == nums[ i ] )
            {
                c2++;
                continue;
            }

            if ( c1 == 0 )
            {
                v1 = nums[ i ];
                c1 = 1;
                continue;
            }
            if ( c2 == 0 )
            {
                v2 = nums[ i ];
                c2 = 1;
                continue;
            }
            c1--;
            c2--;
        }
        c1 = 0;
        c2 = 0;
        for ( int i = 0; i < nums.length; i++ )
        {
            if ( v1 == nums[ i ] ) c1++;
            if ( v2 == nums[ i ] ) c2++;
        }
        int l = nums.length / 3;
        if ( c1 > l ) res.add( v1 );

        if ( v1 != v2 && c2 > l )
        {
            res.add( v2 );
        }
        return res;
    }
}
