package com.algorithms.array.leetcode;

import java.util.HashMap;

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
        if ( s.indexOf( t ) != -1 ) return t;
        int r = 0;
        int l = 0;
        HashMap< Character, Integer > map = new HashMap<>();
        String res = s;
        int times = 0;
        while ( l < s.length() )
        {
            if ( times < t.length() )
            {
                if ( r < s.length() && t.indexOf( s.charAt( r ) ) != -1 )
                {
                    map.put( s.charAt( r ), r );

                }
                r++;
                if ( r > s.length() ) return "";
            }
            else
            {
                int first = s.length() + 1;
                for ( Character c : map.keySet() )
                {
                    first = Math.min( first, map.get( c ) );
                }

                String temp = s.substring( first, r );
                res = temp.length() < res.length() ? temp : res;
                int count = 0;
                for ( Character c : map.keySet() )
                {
                    l = map.get( c );
                    count++;
                    if ( count == 2 ) break;
                }
                if ( r == s.length() ) break;
                r = l;
                map.clear();

            }
            times++;
        }

        return res;

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
                        length = Math.min( length, r - l + 1 );
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
        //        "cabwefgewcwaefgcf"
        //        "cae"
        System.out.println( minWindowSolution( "cabwefgewcwaefgcf", "cae" ) );
    }
}
