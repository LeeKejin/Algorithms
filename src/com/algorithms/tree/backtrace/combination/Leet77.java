package com.algorithms.tree.backtrace.combination;

import java.util.ArrayList;
import java.util.List;

public class Leet77
{
    static List< List< Integer > > results = new ArrayList<>();

    public static List< List< Integer > > combine( int n, int k )
    {
        if ( k == 0 ) return new ArrayList<>();
        back( 1, n, k, new ArrayList< Integer >() );
        return results;
    }

    private static void back( int start, int n, int k, ArrayList< Integer > list )
    {
        if ( list.size() == k )
        {
            results.add( new ArrayList<>( list ) );
            return;
        }
        System.out.println( "Start: " + start );
        int limit = n - ( k - list.size() ) + 1;
        System.out.println( "Limit: " + limit + "---- list.size " + list.size() );
        for ( int i = start; i <= limit; i++ )
        {
            if ( list.contains( i ) ) continue;
            list.add( i );

            back( i + 1, n, k, list );
            list.remove( list.size() - 1 );
        }
    }

    public static void main( String[] args )
    {
        System.out.println( combine( 4, 2 ) );
    }
}
