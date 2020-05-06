package com.algorithms.array.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet76
{
    //Not Working...
    public static String minWindow( String s, String t )
    {
        if ( s.length() < t.length() ) return "";
        if ( s.length() == t.length() )
        {
            for ( char c : s.toCharArray() )
            {
                if ( t.indexOf( c ) == -1 ) return "";
            }
            return s;
        }
        if ( t.length() == 1 && s.indexOf( t ) == -1 ) return "";
        if ( t.length() == 1 && s.indexOf( t ) != -1 ) return t;
        if ( s.indexOf( t ) != -1 ) return t;
        int r = 0;
        int l = 0;
        int length = s.length() + 1;
        int begin = 0;
        List< Map< Character, Integer > > list = new ArrayList<>();
        String res = s;
        int[] freq = new int[ 256 ];
        for ( char c : t.toCharArray() )
        {
            freq[ c ]++;
        }

        while ( r < s.length() )
        {
            freq[ s.charAt( r ) ]--;
            if ( freq[ s.charAt( r ) ] >= 0 )
            {
                Map< Character, Integer > map = new HashMap<>();
                map.put( s.charAt( r ), r );
                list.add( map );

            }
            while ( list.size() == t.length() )
            {
                freq[ s.charAt( l ) ]++;
                l = getIndex( list.get( 0 ) );
                if ( length > ( r - l + 1 ) )
                {
                    length = r - l + 1;
                    begin = l;
                }
                l++;
                r = l;
                --r;
                for ( char c : t.toCharArray() )
                {
                    freq[ c ]++;
                }
                list.clear();
            }
            r++;

        }

        return length == ( s.length() + 1 ) ? "" : s.substring( begin, begin + length );

    }

    static int getIndex( Map< Character, Integer > map )
    {
        for ( Character c : map.keySet() )
        {
            return map.get( c );
        }
        return -1;
    }

    public static String minWindowSolution( String s, String t )
    {
        int r = 0;
        int l = 0;
        int count = t.length();
        int[] freq = new int[ 256 ];
        int length = s.length() + 1;
        int begin = 0;
        for ( char c : t.toCharArray() )
        {
            freq[ c ]++;
        }
        while ( r < s.length() )
        {
            freq[ s.charAt( r ) ]--;
            if ( freq[ s.charAt( r ) ] >= 0 ) count--;

            while ( count == 0 )
            {
                freq[ s.charAt( l ) ]++;
                if ( freq[ s.charAt( l ) ] > 0 )
                {
                    if ( r - l + 1 < length )
                    {
                        begin = l;
                        length = r - l + 1;
                    }

                    count++;
                }
                l++;
            }
            r++;
        }

        return length == ( s.length() + 1 ) ? "" : s.substring( begin, begin + length );

    }

    public static void main( String[] args )
    {
        System.out.println( minWindow( "cabwefgewcwaefgcf", "cae" ) );
    }
}
