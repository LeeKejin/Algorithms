package com.algorithms.dynamicprogramming.singlestring.largestsum;

public class MaxMatrix
{

    public int[] getMaxMatrix( int[][] matrix )
    {
        int n = matrix.length;
        int m = matrix[ 0 ].length;
        int[] temp = new int[ m ];
        int[] pos = new int[ 4 ];
        int r1 = 0;
        int c1 = 0;

        int max = Integer.MIN_VALUE;

        for ( int i = 0; i < n; i++ )
        {
            for ( int x = 0; x < m; x++ ) temp[ x ] = 0;
            for ( int j = i; j < n; j++ )
            {
                int sum = 0;
                for ( int k = 0; k < m; k++ )
                {
                    temp[ k ] += matrix[ j ][ k ];
                    if ( sum > 0 )
                    {
                        sum += temp[ k ];
                    }
                    else
                    {
                        sum = temp[ k ];
                        r1 = i;
                        c1 = k;
                    }
                    if ( sum > max )
                    {
                        max = sum;
                        pos[ 0 ] = r1;
                        pos[ 1 ] = c1;
                        pos[ 2 ] = j;
                        pos[ 3 ] = k;

                    }
                }
            }
        }

        return pos;
    }
}
