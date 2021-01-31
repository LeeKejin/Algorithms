package com.algorithms.dynamicprogramming.knapsack;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct
{
    Map< String, Boolean > map = new HashMap<>();

    public boolean canConstruct( String target, String[] strs )
    {

        if ( target.equals( "" ) )
        {
            return true;
        }
        for ( String str : strs )
        {
            if ( target.startsWith( str ) )
            {
                String newTarget = target.substring( str.length() );
                boolean res;
                if ( map.containsKey( newTarget ) )
                {
                    res = map.get( newTarget );
                }
                else
                {
                    res = canConstruct( newTarget, strs );
                    map.put( newTarget, res );
                }
                if ( !res )
                {
                    continue;
                }
                else
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canConstructDP( String s, String[] wordDict )
    {
        boolean dp[] = new boolean[ s.length() + 1 ];
        dp[ 0 ] = true;
        for ( int i = 0; i < s.length(); i++ )
        {
            if ( dp[ i ] )
            {
                for ( String word : wordDict )
                {
                    String target = s.substring( i );
                    if ( target.startsWith( word ) )
                    {
                        int len = word.length();
                        if ( len + i < dp.length )
                        {
                            dp[ i + len ] = true;
                        }
                    }
                }
            }
        }
        return dp[ s.length() ];
    }

    public static void main( String[] args )
    {
        CanConstruct c = new CanConstruct();
        System.out
            .println(
                c.canConstruct( "enterapotentpot", new String[] { "a", "p", "ent", "enter", "ot", "o", "t" } ) );
        System.out.println( c.canConstruct( "abcdef", new String[] { "ab", "abc", "cd", "def", "abcd" } ) );
    }
}
