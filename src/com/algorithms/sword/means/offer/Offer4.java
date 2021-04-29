package com.algorithms.sword.means.offer;

public class Offer4
{
    public boolean findNumberIn2DArray( int[][] matrix, int target )
    {
        if ( matrix.length == 0 ) return false;
        int h = 0;
        int w = matrix[ 0 ].length - 1;
        while ( h < matrix.length && w >= 0 )
        {
            if ( matrix[ h ][ w ] == target )
            {
                return true;
            }
            else if ( matrix[ h ][ w ] > target )
            {
                w--;
            }
            else
            {
                h++;
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
        Offer4 o = new Offer4();
        o.findNumberIn2DArray( matrix, 5 );
    }
}
