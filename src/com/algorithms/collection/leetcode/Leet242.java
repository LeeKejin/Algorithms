package com.algorithms.collection.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leet242
{
    public static boolean isAnagram( String s, String t )
    {
        Map< Character, Integer > map = new HashMap<>();
        if ( s.length() != t.length() ) return false;

        for ( int i = 0; i < s.length(); i++ )
        {
            if ( map.containsKey( s.charAt( i ) ) )
            {
                int v = map.get( s.charAt( i ) );
                v++;
                map.put( s.charAt( i ), v );
            }
            else
            {
                map.put( s.charAt( i ), 1 );
            }
        }

        for ( char c : t.toCharArray() )
        {
            if ( map.containsKey( c ) )
            {
                int v = map.get( c );
                v--;
                map.put( c, v );
                if ( v < 0 ) return false;
            }
            else
            {
                return false;
            }
        }

        for ( char c : map.keySet() )
        {
            if ( map.get( c ) != 0 ) return false;
        }
        return true;
    }

    public static boolean isAnagramSolution1( String s, String t )
    {
        if ( s.length() != t.length() ) return false;
        char[] sArr = s.toCharArray();
        Arrays.sort( sArr );
        char[] tArr = t.toCharArray();
        Arrays.sort( tArr );
        return Arrays.equals( sArr, tArr );
    }

    //Fastest one!
    public static boolean isAnagramSolution2( String s, String t )
    {
        if ( s.length() != t.length() ) return false;
        int freq[] = new int[ 26 ];
        for ( char c : s.toCharArray() )
        {
            freq[ c ]++;
        }

        for ( char c : t.toCharArray() )
        {
            freq[ c ]--;
            if ( freq[ c ] < 0 )
            {
                return false;
            }
        }
        for ( int c : freq )
        {
            if ( c != 0 ) return false;
        }
        return true;
    }

    public static void main( String[] args )
    {
        System.out.println( isAnagram( "anagram", "nagaram" ) );
    }
}
