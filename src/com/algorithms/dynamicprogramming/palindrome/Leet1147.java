package com.algorithms.dynamicprogramming.palindrome;

import java.util.ArrayList;
import java.util.List;

public class Leet1147
{
    List< String > list = new ArrayList<>();

    public int longestDecomposition( String text )
    {
        if ( text.length() == 0 ) return 1;
        cal( text );
        return list.size();
    }

    public void cal( String text )
    {
        int n = text.length();
        char startCh = text.charAt( 0 );
        int endIndex = text.lastIndexOf( startCh );
        if ( endIndex == 0 )
        {
            list.add( text );
            return;
        }
        List< String > subList = new ArrayList<>();
        for ( int i = n - 1; i >= n / 2; i-- )
        {
            if ( text.charAt( i ) == startCh )
            {
                int newLength = n - i;
                String startStr = text.substring( 0, newLength );
                String endStr = text.substring( i, n );
                if ( startStr.equals( endStr ) )
                {
                    subList.add( startStr );
                    subList.add( endStr );
                    endIndex = i;
                    break;
                }
            }
        }

        if ( subList.isEmpty() )
        {
            list.add( text );
            return;
        }
        list.addAll( subList );

        int newLength = n - endIndex;
        String newText = text.substring( newLength, endIndex );
        if ( newText.length() == 0 )
        {
            return;
        }

        cal( newText );
    }
}
