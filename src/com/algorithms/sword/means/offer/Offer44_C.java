package com.algorithms.sword.means.offer;

public class Offer44_C
{
    public int findNthDigit( int n )
    {
        int digit = 1;
        long count = 9;
        long start = 1;

        while ( n > count )
        {
            n -= count;
            digit++;
            start *= 10;
            count = 9 * start * digit;
        }
        long num = start + ( n - 1 ) / digit;
        return Integer.parseInt( String.valueOf( String.valueOf( num ).charAt( ( n - 1 ) % digit ) ) );

    }
}
