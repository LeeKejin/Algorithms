package com.algorithms.tree.backtrace.combination;

import java.util.ArrayList;
import java.util.List;

public class Leet78
{
    static List< List< Integer > > results = new ArrayList<>();

    public static List< List< Integer > > subsets( int[] nums )
    {
        if ( nums == null || nums.length == 0 ) return new ArrayList<>();

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
        }
    }

    public static void main( String[] args )
    {
        int[] arr = new int[] { 1, 2, 3 };
        System.out.println( subsets( arr ) );
    }
}
