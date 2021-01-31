package com.algorithms.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet368
{
    public List< Integer > largestDivisibleSubset( int[] nums )
    {
        List< List< Integer > > list = new ArrayList<>();
        Arrays.sort( nums );
        for ( int num : nums )
        {
            List< Integer > inner = new ArrayList<>();
            inner.add( num );
            list.add( inner );
        }

        for ( int i = 1; i < nums.length; i++ )
        {
            for ( int j = 0; j < i; j++ )
            {
                if ( nums[ i ] % nums[ j ] == 0 || nums[ j ] % nums[ i ] == 0 )
                {
                    int s1 = list.get( j ).size();
                    int s2 = list.get( i ).size();
                    if ( s1 + 1 > s2 )
                    {
                        list.get( i ).clear();
                        list.get( i ).addAll( list.get( j ) );
                        list.get( i ).add( nums[ i ] );

                    }

                }
            }
        }
        int l = 0;
        int index = -1;
        for ( int i = 0; i < nums.length; i++ )
        {
            if ( list.get( i ).size() > l )
            {
                l = list.get( i ).size();
                index = i;
            }
        }
        return list.get( index );
    }

}
