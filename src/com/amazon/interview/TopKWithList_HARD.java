package com.amazon.interview;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TopKWithList_HARD
{
    public ArrayList< Integer > kTop( int[] a, int n, int k )
    {
        if ( a.length == 0 ) return new ArrayList<>();
        LinkedHashMap< Integer, Integer > map = new LinkedHashMap<>();
        int top[] = new int[ k + 1 ];
        ArrayList< Integer > list = new ArrayList<>();
        map.put( 0, 0 );
        for ( int num : a )
        {
            if ( map.containsKey( num ) )
            {
                int freq = map.get( num );
                freq++;
                map.put( num, freq );

            }
            else
            {
                map.put( num, 1 );
            }
            top[ k ] = num;
            int indexOfNumInTop = find( top, num );
            for ( int i = indexOfNumInTop - 1; i >= 0; i-- )
            {
                if ( map.get( top[ i ] ) < map.get( top[ i + 1 ] ) || ( map.get( top[ i ] ) == map.get( top[ i + 1 ] )
                    && top[ i ] > top[ i + 1 ] ) )
                {
                    swap( top, i );
                }
            }
            for ( int j = 0; j < k && top[ j ] != 0; j++ )
            {
                list.add( top[ j ] );
            }
        }

        return list;
    }

    private void swap( int[] top, int i )
    {
        int t = top[ i + 1 ];
        top[ i + 1 ] = top[ i ];
        top[ i ] = t;
    }

    private int find( int[] top, int num )
    {
        for ( int i = 0; i < top.length; i++ )
        {
            if ( num == top[ i ] ) return i;
        }
        return -1;
    }
}
