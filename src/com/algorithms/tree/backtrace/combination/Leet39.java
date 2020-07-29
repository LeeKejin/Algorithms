package com.algorithms.tree.backtrace.combination;

import java.util.ArrayList;
import java.util.List;

public class Leet39
{
    static List< List< Integer > > results = new ArrayList<>();

    public static List< List< Integer > > combinationSum( int[] candidates, int target )
    {
        if ( candidates.length == 0 ) return new ArrayList<>();
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
            if ( target - candidates[ i ] < 0 ) break;

            list.add( candidates[ i ] );
            back( candidates, target - candidates[ i ], i, list );
            list.remove( list.size() - 1 );
        }
    }

    public static void main( String[] args )
    {
        int[] arr = new int[] { 1, 2 };
        System.out.println( combinationSum( arr, 4 ) );
    }
}
