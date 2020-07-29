package com.algorithms.tree.backtrace.combination;

import java.util.ArrayList;
import java.util.List;

public class Lee216
{
    static List< List< Integer > > results = new ArrayList<>();

    public static List< List< Integer > > combinationSum3( int k, int n )
    {
        if ( k == 0 && n > 0 ) return new ArrayList<>();
        back( k, n, 1, new ArrayList< Integer >() );
        return results;
    }

    private static void back( int k, int n, int start, ArrayList< Integer > list )
    {
        if ( n == 0 && list.size() == k )
        {
            results.add( new ArrayList<>( list ) );
            return;
        }

        for ( int i = start; i <= 9; i++ )
        {
            if ( n - i < 0 ) break;
            if ( n - i > 0 && ( list.size() + 1 == k ) ) continue;
            list.add( i );
            back( k, n - i, i + 1, list );
            list.remove( list.size() - 1 );
        }
    }

    public static void main( String[] args )
    {
        System.out.println( combinationSum3( 3, 9 ) );
    }
}
