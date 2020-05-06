package com.algorithms.collection.leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Leet451
{
    //Tooooooooo Slooooooow
    public static String frequencySort( String s )
    {
        int[] freq = new int[ 256 ];
        String res = "";
        int count = 0;
        for ( char c : s.toCharArray() )
        {
            freq[ c ]++;
        }
        for ( int i = 0; i < freq.length; i++ )
        {
            if ( freq[ i ] != 0 )
            {
                if ( freq[ i ] == 1 )
                {
                    res = res + ( char ) i;
                }
                else if ( freq[ i ] <= count && freq[ i ] != 1 )
                {
                    String begin = "";
                    String last = "";
                    for ( int k = 0; k < res.length(); k++ )
                    {
                        if ( freq[ res.charAt( k ) ] < freq[ i ] )
                        {
                            begin = res.substring( 0, k );
                            last = res.substring( k, res.length() );
                            break;
                        }
                    }
                    if ( begin.equals( "" ) )
                    {
                        for ( int j = 0; j < freq[ i ]; j++ )
                        {
                            res = res + ( char ) i;
                        }
                    }
                    else
                    {
                        for ( int j = 0; j < freq[ i ]; j++ )
                        {
                            begin += ( char ) i;
                        }
                        res = begin + last;
                    }

                }
                else
                {
                    count = freq[ i ];
                    for ( int j = 0; j < count; j++ )
                    {
                        res = ( char ) i + res;
                    }
                }
            }
        }
        return res;
    }

    public static String frequencySortSolution( String s )
    {
        HashMap< Character, Integer > map = new HashMap<>();
        for ( char c : s.toCharArray() )
        {
            map.put( c, map.getOrDefault( c, 0 ) + 1 );
        }

        PriorityQueue< Character > queue = new PriorityQueue<>( ( a, b ) -> map.get( b ) - map.get( a ) );
        queue.addAll( map.keySet() );
        StringBuilder sb = new StringBuilder();
        while ( queue.size() > 0 )
        {
            Character c = queue.poll();
            for ( int i = 0; i < map.get( c ); i++ )
            {
                sb.append( c );
            }
        }
        return sb.toString();
    }

    public static void main( String[] args )
    {
        System.out.println( frequencySort( "dddccdbba" ) );
    }
}
