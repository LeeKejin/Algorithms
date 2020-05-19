package com.algorithms.collection.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet149
{
    public static int maxPoints( int[][] points )
    {
        if ( points.length == 0 ) return 0;
        if ( points.length == 1 ) return 1;
        int count = 0;

        for ( int i = 0; i < points.length; i++ )
        {
            Map< List< Integer >, Integer > map = new HashMap<>();

            int samePoint = 0;
            int max = 0;
            for ( int j = i + 1; j < points.length; j++ )
            {
                if ( i != j )
                {
                    int x = points[ i ][ 0 ] - points[ j ][ 0 ];
                    int y = points[ i ][ 1 ] - points[ j ][ 1 ];
                    if ( x == 0 && y == 0 )
                    {
                        samePoint++;

                    }
                    else
                    {
                        List< Integer > rel = slope( x, y );
                        map.put( rel, map.getOrDefault( rel, 0 ) + 1 );

                        max = Math.max( max, map.get( rel ) );

                    }
                }
            }
            count = Math.max( count, samePoint + max + 1 );

        }
        return count;
    }

    public static void main( String[] args )
    {
        int str[][] = new int[][] { { 1, 1 }, { 3, 2 }, { 5, 3 }, { 4, 1 }, { 2, 3 }, { 1, 4 } };
        //        int str[][] = new int[][] { { 1, 1 }, { 2, 2 }, { 3, 3 } };
        //        int str[][] = new int[][] { { 0, 0 }, { 1, 1 }, { 1, -1 } };
        //
        System.out.println( maxPoints( str ) );
        System.out.print( 2 % ( -2 ) );
    }

    public static List< Integer > slope( int dx, int dy )
    {
        if ( dx == 0 ) return Arrays.asList( 1, 0 );
        if ( dy == 0 ) return Arrays.asList( 0, 1 );
        int d = gcd( dy, dx );
        return Arrays.asList( dx / d, dy / d );
    }

    public static int gcd( int m, int n )
    {
        if ( n != 0 )
        {
            m = gcd( n, m % n );
        }
        return m;
    }
}
