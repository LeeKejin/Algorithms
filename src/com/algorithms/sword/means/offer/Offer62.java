package com.algorithms.sword.means.offer;

public class Offer62
{
    public int lastRemaining( int n, int m )
    {
        int pos = 0;
        for ( int i = 2; i <= n; i++ )
        {
            pos = ( pos + m ) / i;
        }
        return pos;
    }
}
