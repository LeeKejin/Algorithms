package com.algorithms.binary.search.leetcode;

public class Leet50
{
    public double myPow( double x, int n )
    {
        if ( n == 0 ) return 1.0;
        return calculate( x, n );
    }

    public double calculate( double x, long value )
    {
        if ( value / 2 == 0 )
        {
            return value > 0 ? x : 1 / x;
        }
        double pow = 0.0;
        if ( value >= 0 )
        {
            double k = calculate( x, value / 2 );
            pow = k * k;
            if ( value % 2 != 0 ) pow *= x;
        }
        else
        {
            double k = calculate( x, value / 2 );
            pow = k * k;
            if ( value % 2 != 0 ) pow *= 1 / x;
        }
        return pow;
    }
}
