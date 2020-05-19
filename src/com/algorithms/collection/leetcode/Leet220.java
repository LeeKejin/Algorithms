package com.algorithms.collection.leetcode;

import java.util.TreeSet;

public class Leet220
{
    public static boolean containsNearbyAlmostDuplicate( int[] nums, int k, int t )
    {
        if ( k <= 0 ) return false;
        TreeSet< Long > set = new TreeSet< Long >();
        for ( int i = 0; i < nums.length; i++ )
        {

            if ( !set.isEmpty() )
            {
                long v = ( long ) nums[ i ] - ( long ) t;
                if ( set.ceiling( v ) != null && set.ceiling( v ) <= ( ( long ) nums[ i ] + ( long ) t ) )
                {
                    return true;
                }
            }
            if ( set.size() >= k )
            {
                set.remove( ( long ) nums[ i - k ] );
            }
            set.add( ( long ) nums[ i ] );
        }
        return false;
    }

    public static boolean containsNearbyAlmostDuplicateSolution1( int[] nums, int k, int t )
    {
        if ( k <= 0 ) return false;
        TreeSet< Long > set = new TreeSet< Long >();
        for ( int i = 0; i < nums.length; i++ )
        {

            if ( !set.isEmpty() )
            {
                long v = ( long ) nums[ i ] + ( long ) t;
                if ( set.floor( v ) != null && set.floor( v ) >= ( ( long ) nums[ i ] - ( long ) t ) )
                {
                    return true;
                }
            }
            if ( set.size() >= k )
            {
                set.remove( ( long ) nums[ i - k ] );
            }
            set.add( ( long ) nums[ i ] );
        }
        return false;
    }

    public static void main( String[] args )
    {
        int[] arr = new int[] { 1, 5, 9, 1, 5, 9 };

        //        int[] arr = new int[] { 3, 1 };

        System.out.print( containsNearbyAlmostDuplicate( arr, 100, 1 ) );
    }
}
