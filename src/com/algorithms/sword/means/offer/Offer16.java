package com.algorithms.sword.means.offer;

public class Offer16
{
    public double myPow( double x, int n )
    {
        if ( n == 0 ) return 1;
        long b = n;
        if ( n < 0 )
        {
            x = 1 / x;
            b = 0 - b;
        }
        double res = 1.0;
        while ( b > 0 )
        {
            if ( b % 2 == 1 ) res *= x;
            x *= x;
            b /= 2;
        }
        return res;
    }

}
