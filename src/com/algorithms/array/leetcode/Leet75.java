package com.algorithms.array.leetcode;

public class Leet75
{
    public static void sortColors( int[] nums )
    {
        int[] count = new int[ 3 ];
        for ( int i = 0; i < nums.length; i++ )
        {
            assert ( nums[ i ] >= 0 && nums[ i ] <= 2 );
            count[ nums[ i ] ]++;
        }

        int index = 0;

        for ( int j = 0; j < count[ 0 ]; j++ )
        {
            nums[ index++ ] = 0;
        }

        for ( int j = 0; j < count[ 1 ]; j++ )
        {
            nums[ index++ ] = 1;
        }
        for ( int j = 0; j < count[ 2 ]; j++ )
        {
            nums[ index++ ] = 2;
        }

    }

    public static void sortColorsOptimize( int[] nums )
    {
        int firstIndex = 0;
        int lastIndex = nums.length - 1;

        for ( int i = 0; i <= lastIndex; )
        {
            if ( nums[ i ] == 1 )
            {
                i++;
            }
            else if ( nums[ i ] < 1 )
            {
                int temp = nums[ firstIndex ];
                nums[ firstIndex ] = nums[ i ];
                nums[ i ] = temp;
                firstIndex++;
                i++;
            }
            else
            {
                int temp = nums[ lastIndex ];
                nums[ lastIndex ] = nums[ i ];
                nums[ i ] = temp;
                lastIndex--;
            }
        }

    }

    public static void main( String[] args )
    {
        int[] test = new int[] { 2, 0, 2, 1, 1, 0 };
        sortColorsOptimize( test );
    }

}
