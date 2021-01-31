package com.algorithms.dynamicprogramming.singlestring.largestsum;

public class Leet363
{
    public int maxSumSubmatrix( int[][] matrix, int k )
    {
        int h = matrix.length;
        int w = matrix[ 0 ].length;
        int[] temp = new int[ w ];
        int r1 = 0;
        int c1 = 0;
        int max = Integer.MIN_VALUE;

        for ( int i = 0; i < h; i++ )
        {
            for ( int x = 0; x < w; x++ ) temp[ x ] = 0;
            for ( int j = i; j < h; j++ )
            {
                for ( int y = 0; y < w; y++ )
                {
                    temp[ y ] += matrix[ j ][ y ];
                }
                max = Math.max( max, dpMax( temp, k ) );
                if ( max == k ) return max;
            }

        }

        return max;
    }

    private int dpMax( int[] temp, int k )
    {
        int max = temp[ 0 ];
        int sum = temp[ 0 ];
        for ( int i = 1; i < temp.length; i++ )
        {
            sum = Math.max( sum, 0 ) + temp[ i ];
            if ( max < sum ) max = sum;
        }

        if ( max <= k ) return max;

        int res = Integer.MIN_VALUE;
        //Calculated subString's largest sum
        for ( int l = 0; l < temp.length; l++ )
        {
            int val = 0;
            for ( int r = l; r < temp.length; r++ )
            {
                val += temp[ r ];
                if ( val > res && val <= k ) res = val;
                if ( res == k ) return k;
            }
        }
        return res;
    }
}
