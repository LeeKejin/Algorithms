package com.amazon.interview.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Leet1005
{
    public int largestSumAfterKNegations( int[] A, int K )
    {
        Integer[] temp = new Integer[ A.length ];
        for ( int i = 0; i < A.length; i++ )
        {
            temp[ i ] = A[ i ];
        }

        Comparator< Integer > comparator = new Comparator< Integer >()
        {
            @Override
            public int compare( Integer o1, Integer o2 )
            {
                return Math.abs( o2 ) - Math.abs( o1 );
            }
        };

        Arrays.sort( temp, comparator );

        for ( int i = 0; i < temp.length; i++ )
        {
            if ( temp[ i ] < 0 && K > 0 )
            {
                temp[ i ] *= -1;
                K--;
            }
        }
        if ( K % 2 == 1 ) temp[ temp.length - 1 ] *= -1;

        int sum = 0;
        for ( int a : temp )
        {
            sum += a;
        }
        return sum;
    }
}
