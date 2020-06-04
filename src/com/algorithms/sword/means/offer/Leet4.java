package com.algorithms.sword.means.offer;

public class Leet4
{
    public boolean findNumberIn2DArray( int[][] matrix, int target )
    {
        if ( matrix.length <= 0 ) return false;

        int h = matrix.length;
        int w = matrix[ 0 ].length - 1;
        int i = 0;
        while ( h > i && w >= 0 )
        {
            int val = matrix[ i ][ w ];
            if ( matrix[ i ][ w ] == target ) return true;
            if ( matrix[ i ][ w ] > target )
            {
                w--;
            }
            else
            {
                i++;
            }
        }
        return false;
    }

    public static void main( String[] args )
    {
        int[][] matrix = new int[][] {
            { 3, 5, 9, 9, 14 },
            { 7, 8, 11, 15, 15 },
            { 8, 10, 16, 16, 17 },
        };
    }
}
