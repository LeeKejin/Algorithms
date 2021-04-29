package com.algorithms.sword.means.offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Offer38_C
{
    List< String > list = new ArrayList<>();
    char[] arr;

    public String[] permutation( String s )
    {
        arr = s.toCharArray();
        dfs( 0 );
        String[] res = new String[ list.size() ];
        for ( int i = 0; i < res.length; i++ )
        {
            res[ i ] = list.get( i );
        }
        return res;
    }

    private void dfs( int index )
    {
        if ( index == arr.length - 1 )
        {
            list.add( String.valueOf( arr ) );
            return;
        }
        Set< Character > set = new HashSet<>();
        for ( int i = index; i < arr.length; i++ )
        {
            if ( set.contains( arr[ i ] ) ) continue;
            set.add( arr[ i ] );
            swap( arr, i, index );
            dfs( index + 1 );
            swap( arr, index, i );
        }
    }

    public void swap( char[] arr, int i, int j )
    {
        char temp = arr[ i ];
        arr[ i ] = arr[ j ];
        arr[ j ] = temp;
    }
}
