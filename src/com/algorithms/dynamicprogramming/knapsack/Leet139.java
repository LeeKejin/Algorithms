package com.algorithms.dynamicprogramming.knapsack;

import java.util.List;

public class Leet139
{
    public boolean wordBreak( String s, List< String > wordDict )
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
}
