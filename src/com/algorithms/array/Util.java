package com.algorithms.array;

public class Util
{
    public static Integer[] generateRandomArray( int n, int rangeL, int rangeR )
    {
        Integer[] arr = new Integer[ n ];
        for ( int i = 0; i < n; i++ )
        {
            arr[ i ] = ( int ) ( Math.random() * ( rangeR - rangeL + 1 ) ) + rangeL;
        }
        return arr;
    }

    public static Integer[] generateOrderedArray(int n) {

        assert n > 0;

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++)
            arr[i] = i;
        return arr;
    }
}
