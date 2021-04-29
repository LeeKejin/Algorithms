package com.algorithms.sword.means.offer;

public class Offer66
{
    public int[] constructArr( int[] a )
    {
        if ( a.length == 0 ) return new int[] {};
        int b[] = new int[ a.length ];
        b[ 0 ] = 1;
        for ( int i = 1; i < a.length; i++ )
        {
            b[ i ] = a[ i - 1 ] * b[ i - 1 ];
        }
        int temp = 1;
        for ( int j = a.length - 2; j >= 0; j-- )
        {
            temp *= a[ j + 1 ];
            b[ j ] *= temp;
        }
        return b;
    }
}
