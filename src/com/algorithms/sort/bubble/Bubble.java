package com.algorithms.sort.bubble;

public class Bubble
{
    Integer[] bubbleSort( Integer[] arr )
    {
        for ( int i = arr.length - 1; i >= 0; i-- )
        {
            boolean isSwap = false;
            int index = i;
            for ( int j = 1; j <= i; j++ )
            {

                if ( arr[ j - 1 ] > arr[ j ] )
                {
                    swap( arr, j, j - 1 );
                    isSwap = true;
                    index = j;
                }
            }
            if ( !isSwap ) return arr;
            i = index;
        }
        return arr;
    }

    public void swap( Integer[] arr, int x, int y )
    {
        int temp = arr[ x ];
        arr[ x ] = arr[ y ];
        arr[ y ] = temp;
    }
}
