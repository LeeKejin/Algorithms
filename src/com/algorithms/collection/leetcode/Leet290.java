package com.algorithms.collection.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leet290
{
    public static boolean wordPattern( String pattern, String str )
    {
        String[] words = str.split( " " );
        if ( pattern.length() != words.length ) return false;
        Map< Character, Integer > charMap = new HashMap<>();
        Map< String, Integer > stringMap = new HashMap<>();

        for ( int i = 0; i < pattern.length(); i++ )
        {
            int indexC = charMap.getOrDefault( pattern.charAt( i ), -1 );
            int indexS = stringMap.getOrDefault( words[ i ], -1 );
            if ( indexC != indexS )
            {
                return false;
            }
            charMap.put( pattern.charAt( i ), i );
            stringMap.put( words[ i ], i );
        }

        return true;
    }

    //Fastest
    public static boolean wordPatternSolution1( String pattern, String str )
    {
        String[] words = str.split( " " );
        if ( pattern.length() != words.length ) return false;
        Map< Character, String > map = new HashMap<>();

        for ( int i = 0; i < pattern.length(); i++ )
        {
            if ( !map.containsKey( pattern.charAt( i ) ) && !map.containsValue( words[ i ] ) )
            {
                map.put( pattern.charAt( i ), words[ i ] );
            }
            else if ( map.containsKey( pattern.charAt( i ) ) && !map.get( pattern.charAt( i ) ).equals( words[ i ] ) )
            {
                return false;
            }
            else if ( !map.containsKey( pattern.charAt( i ) ) && map.containsValue( words[ i ] ) )
            {
                return false;
            }
        }

        return true;
    }

    public static void main( String[] args )
    {

        System.out.println( wordPattern( "abba", "dog cat cat dog" ) );
    }
}
