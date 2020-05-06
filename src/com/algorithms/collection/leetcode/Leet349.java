package com.algorithms.collection.leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class Leet349
{
    public static int[] intersection( int[] nums1, int[] nums2 )
    {
        HashSet< Integer > set = new HashSet<>();
        for ( int num : nums1 )
        {
            set.add( num );
        }
        HashSet< Integer > res = new HashSet<>();
        for ( int num : nums2 )
        {
            if ( set.contains( num ) )
            {
                res.add( num );
            }
        }
        int count = 0;
        int[] r = new int[ res.size() ];
        for ( int v : set )
        {
            if ( count > set.size() ) break;
            r[ count ] = v;
            count++;
        }

        return r;
    }

    public static int[] intersectionSolution2( int[] nums1, int[] nums2 )
    {
        HashSet< Integer > set1 = new HashSet<>();
        for ( int num : nums1 )
        {
            set1.add( num );
        }
        HashSet< Integer > set2 = new HashSet<>();
        for ( int num : nums2 )
        {
            set2.add( num );
        }
        if ( set1.size() > set2.size() ) return compareResult( set1, set2 );
        return compareResult( set2, set1 );
    }

    private static int[] compareResult( HashSet< Integer > big, HashSet< Integer > small )
    {
        int[] output = new int[ big.size() ];
        int idx = 0;
        for ( Integer s : big )
            if ( small.contains( s ) ) output[ idx++ ] = s;

        return Arrays.copyOf( output, idx );
    }

    public static void main( String[] args )
    {
        System.out.println( intersectionSolution2( new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 } ) );
    }
}
