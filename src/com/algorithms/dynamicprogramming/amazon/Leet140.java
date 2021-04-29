package com.algorithms.dynamicprogramming.amazon;

import java.util.ArrayList;
import java.util.List;

public class Leet140
{
    public List< String > wordBreak( String s, List< String > wordDict )
    {
        if ( s.length() == 0 || wordDict.size() == 0 ) return new ArrayList<>();
        boolean dp[] = new boolean[ s.length() + 1 ];
        dp[ 0 ] = true;

        for ( int i = 1; i <= s.length(); i++ )
        {
            if ( dp[ i - 1 ] )
            {
                String str = s.substring( i - 1 );
                for ( String word : wordDict )
                {
                    if ( str.startsWith( word ) )
                    {
                        dp[ i + word.length() - 1 ] = true;
                    }
                }
            }
        }
        if ( !dp[ s.length() ] ) return new ArrayList<>();
        List< List< String > > strs = new ArrayList<>();
        int len = s.length();
        for ( int i = 0; i <= len; i++ )
        {
            List< String > list = new ArrayList<>();
            strs.add( list );
        }

        for ( int i = 1; i <= len; i++ )
        {
            if ( !dp[ i ] ) continue;
            for ( int j = 0; j < i; j++ )
            {
                if ( !dp[ j ] ) continue;
                String str = s.substring( j, i );
                if ( !wordDict.contains( str ) ) continue;

                if ( strs.get( j ).isEmpty() )
                {
                    strs.get( i ).add( str );
                }
                else
                {
                    for ( String existingWord : strs.get( j ) )
                    {
                        String combo = existingWord + " " + str;
                        strs.get( i ).add( combo );
                    }
                }
            }
        }
        return strs.get( len );
    }
}
