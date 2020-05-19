package com.algorithms.collection.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leet447
{
    public static int numberOfBoomerangs( int[][] points )
    {
        int count = 0;
        for ( int i = 0; i < points.length; i++ )
        {
            Map< Integer, Integer > map = new HashMap<>(); //key: distance value:freq

            for ( int j = 0; j < points.length; j++ )
            {
                if ( i != j )
                {
                    int d = distance( points[ i ], points[ j ] );
                    map.put( d, map.getOrDefault( d, 0 ) + 1 );
                }
            }
            for ( int distance : map.keySet() )
            {

                count += map.get( distance ) * ( map.get( distance ) - 1 );

            }
        }

        return count;
    }

    private static int distance( int[] pointA, int[] pointB )
    {
        return ( pointA[ 0 ] - pointB[ 0 ] ) * ( pointA[ 0 ] - pointB[ 0 ] ) +
            ( pointA[ 1 ] - pointB[ 1 ] ) * ( pointA[ 1 ] - pointB[ 1 ] );
    }

    public static void main( String[] args )
    {
        int str[][] = new int[][] { { 0, 0 }, { 1, 0 }, { 2, 0 } };

        numberOfBoomerangs( str );
    }
}
