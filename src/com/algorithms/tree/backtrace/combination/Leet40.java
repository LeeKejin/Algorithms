package com.algorithms.tree.backtrace.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet40
{
    static List< List< Integer > > results = new ArrayList<>();

    public static List< List< Integer > > combinationSum2( int[] candidates, int target )
    {
        if ( candidates.length <= 0 ) return new ArrayList<>();
        Arrays.sort( candidates );
        back( candidates, target, 0, new ArrayList< Integer >() );
        return results;

    }

    private static void back( int[] candidates, int target, int start, ArrayList< Integer > list )
    {
        if ( target == 0 )
        {
            results.add( new ArrayList<>( list ) );
            return;
        }

        for ( int i = start; i < candidates.length; i++ )
        {
            if ( target - candidates[ i ] < 0 ) continue;
            list.add( candidates[ i ] );

            back( candidates, target - candidates[ i ], i + 1, list );

            list.remove( list.size() - 1 );
            if ( i + 1 < candidates.length && candidates[ i ] == candidates[ i + 1 ] )
            {
                int count = num( candidates, i );
                i += count;
            }
        }
    }

    static int num( int[] candidates, int start )
    {
        int count = 0;
        int temp = candidates[ start ];
        for ( int i = start + 1; i < candidates.length; i++ )
        {
            if ( temp == candidates[ i ] )
            {
                count++;
            }
        }
        return count;
    }

    public static void main( String[] args )
    {
        int[] arr = new int[] { 1, 1 };
        System.out.println( combinationSum2( arr, 1 ) );
    }
}
