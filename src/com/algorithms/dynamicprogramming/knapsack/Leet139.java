package com.algorithms.dynamicprogramming.knapsack;

import java.util.List;

public class Leet139
{
    public boolean wordBreak( String s, List< String > wordDict )
    {
        if ( s.length() == 0 || wordDict.size() == 0 ) return false;

        boolean dp[] = new boolean[ s.length() + 1 ];
        dp[ 0 ] = true;
        for ( int i = 1; i <= s.length(); i++ )
        {
            if ( dp[ i - 1 ] )
            {
                for ( String word : wordDict )
                {
                    String str = s.substring( i - 1 );
                    if ( str.startsWith( word ) )
                    {
                        dp[ i + word.length() - 1 ] = true;
                    }
                }
            }

        }
        return dp[ s.length() ];
    }
}
