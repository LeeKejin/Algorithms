package com.google.dp.knapsack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountConstruct
{
    Map< String, Integer > map = new HashMap<>();
    int res = 0;

    public int countConstruct( String target, String[] strs )
    {
        find( target, strs );
        return res;
    }

    private int find( String target, String[] strs )
    {
        if ( target.equals( "" ) )
        {
            return 1;
        }
        for ( String str : strs )
        {
            if ( target.startsWith( str ) )
            {
                String newTarget = target.substring( str.length() );
                if ( map.containsKey( newTarget ) )
                {
                    int v = map.get( newTarget );
                    res += v;
                    map.put( newTarget, res );
                }
                else
                {
                    int v = find( newTarget, strs );
                    res += v;
                    map.put( newTarget, res );
                }

            }
        }
        return 0;
    }

    public int countConstructDP( String target, List< String > wordBank )
    {
        int dp[] = new int[ target.length() + 1 ];
        dp[ 0 ] = 1;
        for ( int i = 0; i < target.length(); i++ )
        {
            if ( dp[ i ] != 0 )
            {
                String s = target.substring( i );
                for ( String word : wordBank )
                {
                    if ( s.startsWith( word ) )
                    {
                        if ( i + word.length() < dp.length )
                        {
                            dp[ i + word.length() ] += dp[ i ]; //increase by the number of current position
                        }
                    }
                }

            }
        }
        return dp[ target.length() ];
    }

}
