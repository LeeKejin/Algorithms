package com.algorithms.collection.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leet205
{
    public boolean isIsomorphic( String s, String t )
    {
        Map< Character, Character > map = new HashMap<>();
        if ( t.length() != s.length() ) return false;
        for ( int i = 0; i < s.length(); i++ )
        {
            if ( !map.containsKey( s.charAt( i ) ) && !map.containsValue( t.charAt( i ) ) )
            {
                map.put( s.charAt( i ), t.charAt( i ) );
            }
            if ( map.containsKey( s.charAt( i ) )
                && Character.compare( map.get( s.charAt( i ) ), t.charAt( i ) ) != 0 )
            {
                return false;
            }
            if ( !map.containsKey( s.charAt( i ) ) && map.containsValue( t.charAt( i ) ) )
            {
                return false;
            }
        }
        return true;
    }

    public static boolean isIsomorphicSolution( String s, String t )
    {
        int[] freqS = new int[ 256 ];
        int[] freqT = new int[ 256 ];
        int length = s.length();

        for ( int i = 0; i < s.length(); i++ )
        {
            char cs = s.charAt( i );
            char ct = t.charAt( i );

            if ( freqS[ cs ] == 0 )
            {
                freqS[ cs ] = length * ( i + 1 );
            }
            else
            {
                freqS[ cs ]++;
            }
            if ( freqT[ ct ] == 0 )
            {
                freqT[ ct ] = length * ( i + 1 );
            }
            else
            {
                freqT[ ct ]++;
            }
            if ( freqS[ cs ] != freqT[ ct ] ) return false;

        }

        return true;

    }

    public static void main( String[] args )
    {
        System.out.println( isIsomorphicSolution( "ab", "aa" ) );
    }
}
