package com.algorithms.binary.search.leetcode;

import java.util.Arrays;

public class Leet875
{
    public int minEatingSpeed( int[] piles, int H )
    {
        return minEatingSpeed( piles, H, 1, Arrays.stream( piles ).max().getAsInt() );
    }

    private int minEatingSpeed( int[] piles, int h, int min, int max )
    {
        if ( min > max ) return -1;
        if ( min == max ) return min;
        int mid = min + ( max - min ) / 2;
        int requiredHours = calculateEatingTime( piles, mid );
        if ( requiredHours > h )
        {
            return minEatingSpeed( piles, h, mid + 1, max );
        }

        return minEatingSpeed( piles, h, min, mid );
    }

    private int calculateEatingTime( int[] piles, int k )
    {
        int count = 0;
        for ( int pile : piles )
        {
            count += pile / k;
            if ( pile % k > 0 ) count++;
        }
        return count;
    }

    public static void main( String[] args )
    {
        Leet875 search = new Leet875();
        int[] pile = new int[] { 3, 6, 7, 11 };
        System.out.println( search.minEatingSpeed( pile, 8 ) );
    }
}
