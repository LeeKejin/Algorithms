package com.algorithms.collection.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leet219
{
    public boolean containsNearbyDuplicate( int[] nums, int k )
    {
        for ( int i = 0; i < nums.length; i++ )
        {
            for ( int j = i + 1; j < nums.length; j++ )
            {
                if ( nums[ i ] == nums[ j ] && ( j - i ) <= k ) return true;
            }
        }
        return false;
    }

    public static boolean containsNearbyDuplicateWithSlidingWindow( int[] nums, int k )
    {
        if ( k <= 0 || nums.length == 0 ) return false;

        Set< Integer > set = new HashSet<>();
        for ( int i = 0; i < nums.length; i++ )
        {
            if ( set.contains( nums[ i ] ) ) return true;
            if ( set.size() == k )
            {
                set.remove( nums[ i - k ] );

            }
            set.add( nums[ i ] );
        }
        return false;
    }

    public static void main( String[] args )
    {
        int[] arr = new int[] { 1, 2, 3, 1, 2, 3 };
        System.out.print( containsNearbyDuplicateWithSlidingWindow( arr, 2 ) );
    }

}
