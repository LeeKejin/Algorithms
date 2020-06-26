package com.algorithms.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet17
{
    static Map< Character, List< String > > map = new HashMap<>();
    static List< String > results = new ArrayList<>();
    static int size = 0;

    static
    {
        List< String > list = new ArrayList<>();
        list.add( "a" );
        list.add( "b" );
        list.add( "c" );
        map.put( '2', list );

    }

    public List< String > letterCombinations( String digits )
    {
        if ( results.isEmpty() )
        {
            size = digits.length();
            results.addAll( map.get( digits.charAt( 0 ) ) );
        }

        letterCombinations( digits.substring( 1 ) );
        if ( )

            List< String > list = new ArrayList<>();
        for ( int i = 0; i < digits.length(); i++ )
        {
            composeResults( map.get( digits.charAt( i ) ), list );
        }
    }

    private void composeResults( List< String > subList, List< String > list )
    {
        if ( list.isEmpty() )
        {
            list.addAll( subList );
            return;
        }

        for ( int i = 0; i < list.size(); i++ )
        {
            for ( int j = 0; j < subList.size(); j++ )
            {
                String val =
            }
        }
    }
}
