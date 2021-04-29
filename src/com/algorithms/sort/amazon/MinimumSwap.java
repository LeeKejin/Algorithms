package com.algorithms.sort.amazon;

import java.util.Arrays;

public class MinimumSwap
{
    static int minimumSwaps( int[] arr )
    {
        if ( arr.length == 0 ) return 0;
        int[] temp = Arrays.copyOfRange( arr, 0, arr.length );
        Arrays.sort( temp );
        int res = 0;
        for ( int i = 0; i < arr.length; i++ )
        {
            if ( arr[ i ] != temp[ i ] )
            {
                res++;
                swap( arr, i, tempIndex( arr, temp[ i ] ) );
            }
        }
        return res;
    }

    private static int tempIndex( int[] arr, int val )
    {
        for ( int i = 0; i < arr.length; i++ )
        {
            if ( val == arr[ i ] ) return i;
        }
        return 0;
    }

    private static void swap( int arr[], int i, int j )
    {
        int temp = arr[ i ];
        arr[ i ] = arr[ j ];
        arr[ j ] = temp;
    }
}

