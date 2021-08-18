package com.algorithms.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet15
{
    public List< List< Integer > > threeSum( int[] nums )
    {
        if ( nums.length == 0 ) return new ArrayList<>();
        List< List< Integer > > res = new ArrayList<>();
        Arrays.sort( nums );

        for ( int i = 0; i < nums.length; i++ )
        {
            binarySearch( nums, i, res );

            while ( i + 1 < nums.length && nums[ i + 1 ] == nums[ i ] )
            {
                i++;
            }

        }
        return res;
    }

    private void binarySearch( int[] nums, int i, List< List< Integer > > res )
    {
        int sum = -nums[ i ];
        int start = i + 1;
        int end = nums.length - 1;
        while ( start < end )
        {
            if ( start == i )
            {
                start++;
            }
            else if ( end == i )
            {
                end--;
            }
            else if ( nums[ start ] + nums[ end ] == sum )
            {
                res.add( Arrays.asList( nums[ i ], nums[ start ], nums[ end ] ) );
                while ( end > start && nums[ end ] == nums[ end - 1 ] )
                {
                    end--;
                }
                end--;
            }
            else if ( nums[ start ] + nums[ end ] > sum )
            {
                end--;
            }
            else
            {
                start++;
            }
        }
    }
}
