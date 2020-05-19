package com.algorithms.collection.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leet217
{
    public boolean containsDuplicate( int[] nums )
    {
        Set< Integer > set = new HashSet<>();
        for ( int num : nums )
        {
            set.add( num );
        }
        return !( set.size() == nums.length );
    }

    public static boolean containsDuplicateWithSort( int[] nums )
    {
        Arrays.sort( nums );
        for ( int i = 0; i < nums.length; i++ )
        {
            if ( i + 1 < nums.length && nums[ i ] == nums[ i + 1 ] ) return true;
        }

        return false;
    }

    public static void main( String[] args )
    {
        int[] arr = new int[] { 1, 2, 3, 9, 0, 7, 3, 8, 11 };
        //        int[] arr = new int[] { 3, 1 };

        System.out.print( containsDuplicateWithSort( arr ) );
    }
}
