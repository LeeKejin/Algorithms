package com.amazon.interview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Leet692
{
    public List< String > topKFrequent( String[] words, int k )
    {
        if ( words.length == 0 ) return new ArrayList<>();
        List< String > list = new ArrayList<>();
        Map< String, Integer > map = new HashMap<>();
        for ( String word : words )
        {
            if ( map.containsKey( word ) )
            {
                int freq = map.get( word );
                freq++;
                map.put( word, freq );
            }
            else
            {
                map.put( word, 1 );
            }
        }
        PriorityQueue< String > queue = new PriorityQueue<>( new Comparator< String >()
        {
            @Override
            public int compare( String a, String b )
            {
                return map.get( a ) == map.get( b ) ? a.compareTo( b ) : map.get( b ) - map.get( a );
            }
        } );

        for ( String word : map.keySet() )
        {
            queue.add( word );
        }

        while ( !queue.isEmpty() )
        {
            list.add( queue.poll() );
            if ( list.size() == k ) break;
        }
        return list;
    }
}
