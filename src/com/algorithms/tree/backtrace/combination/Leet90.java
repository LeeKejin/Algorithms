package com.algorithms.tree.backtrace.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet90
{
    static List< List< Integer > > results = new ArrayList<>();

    public static List< List< Integer > > subsetsWithDup( int[] nums )
    {
        if ( nums == null || nums.length == 0 ) return new ArrayList<>();
        Arrays.sort( nums );
        back( nums, 0, new ArrayList< Integer >() );
        return results;
    }

    private static void back( int[] nums, int start, ArrayList< Integer > list )
    {
        results.add( new ArrayList<>( list ) );

        for ( int i = start; i < nums.length; i++ )
        {
            list.add( nums[ i ] );
            back( nums, i + 1, list );
            list.remove( list.size() - 1 );
            if ( i + 1 < nums.length && nums[ i ] == nums[ i + 1 ] )
            {
                int count = numOfDup( nums, nums[ i ], i );
                i += count;
                continue;
            }
        }
    }

    private static int numOfDup( int[] nums, int val, int index )
    {
        int count = 0;
        for ( int i = index + 1; i < nums.length; i++ )
        {
            if ( nums[ i ] == val ) count++;
        }
        return count;
    }

    public static void main( String[] args )
    {
        int[] arr = new int[] { 5, 5, 5, 5, 5 };
        System.out.println( subsetsWithDup( arr ) );
    }
}
