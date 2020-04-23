package com.algorithms.array.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet283
{
    public void moveZeroes( int[] nums )
    {
        List< Integer > list = new ArrayList<>();

        for ( int n : nums )
        {
            if ( n != 0 ) list.add( n );
        }
        for ( int i = 0; i < nums.length; i++ )
        {
            if ( i < list.size() )
            {
                nums[ i ] = list.get( i );
            }
            else
            {
                nums[ i ] = 0;
            }
        }
    }

    public void moveZeroesOptimized( int[] nums )
    {
        int noneZero = 0;
        for ( int i = 0; i < nums.length; i++ )
        {
            if ( nums[ i ] != 0 )
            {
                nums[ noneZero ] = nums[ i ];
                noneZero++;
            }
        }
        for ( int i = noneZero; i < nums.length; i++ )
        {
            nums[ i ] = 0;
        }
    }

    public void moveZeroesSwap( int[] nums )
    {
        int noneZero = 0;
        for ( int i = 0; i < nums.length; i++ )
        {
            if ( nums[ i ] == 0 )
            {
                if ( nums[ noneZero ] != nums[ i ] )
                {
                    int temp = nums[ noneZero ];
                    nums[ noneZero ] = nums[ i ];
                    nums[ i ] = temp;
                }
                noneZero++;
            }
        }
    }
}
