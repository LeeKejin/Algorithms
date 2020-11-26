package com.algorithms.binary.search.leetcode;

import java.util.Arrays;

public class Leet1011
{
    public int shipWithinDays( int[] weights, int D )
    {
        int total = 0;
        for ( int w : weights )
        {
            total += w;
        }
        return shipWithinDays( weights, D, Arrays.stream( weights ).max().getAsInt(), total );
    }

    private int shipWithinDays( int[] weights, int d, int l, int r )
    {
        if ( l > r ) return -1;
        if ( l == r ) return l;
        int mid = l + ( r - l ) / 2;
        int requiredDays = calculateDays( weights, mid );
        if ( requiredDays <= d )
        {
            return shipWithinDays( weights, d, l, mid );
        }
        return shipWithinDays( weights, d, mid + 1, r );
    }

    private int calculateDays( int[] weights, int mid )
    {
        int temp = mid;
        int day = 0;
        int i = 0;
        while ( i < weights.length )
        {
            if ( mid - weights[ i ] >= 0 )
            {
                mid -= weights[ i ];
                i++;
            }
            else
            {
                mid = temp;
                day++;
            }
        }
        return day + 1;
    }

    public static void main( String[] args )
    {
        int[] arr = new int[] { 1, 2, 3, 1, 2 };
        Leet1011 search = new Leet1011();
        System.out.println( search.shipWithinDays( arr, 4 ) );
    }
}
