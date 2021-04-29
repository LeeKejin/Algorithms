package com.algorithms.sword.means.offer;

public class Offer29
{
    public int[] spiralOrder( int[][] matrix )
    {
        if ( matrix.length == 0 ) return new int[] {};
        int m = matrix.length;
        int n = matrix[ 0 ].length;
        int res[] = new int[ m * n ];
        int t = 0;
        int b = m - 1;
        int l = 0;
        int r = n - 1;
        int index = 0;

        while ( true )
        {
            for ( int i = l; i <= r; i++ )
            {
                res[ index ] = matrix[ t ][ i ];
                index++;
            }
            t++;
            if ( t > b ) break;
            for ( int i = t; i <= b; i++ )
            {
                res[ index ] = matrix[ i ][ r ];
                index++;
            }
            r--;
            if ( r < l ) break;
            for ( int i = r; i >= l; i-- )
            {
                res[ index ] = matrix[ b ][ i ];
                index++;
            }
            b--;
            if ( t > b ) break;
            for ( int i = b; i >= t; i-- )
            {
                res[ index ] = matrix[ i ][ l ];
                index++;
            }

            l++;
            if ( l > r ) break;
        }

        return res;
    }
}
