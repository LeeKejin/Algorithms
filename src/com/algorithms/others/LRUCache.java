package com.algorithms.others;

import java.util.LinkedHashMap;

public class LRUCache
{
    int capacity;
    LinkedHashMap< Integer, Integer > map;

    public LRUCache( int capacity )
    {
        this.capacity = capacity;
        map = new LinkedHashMap<>();
    }

    public int get( int key )
    {
        if ( map.containsKey( key ) )
        {
            int val = map.get( key );
            map.remove( key );
            map.put( key, val );
            return val;
        }
        else
        {
            return -1;
        }

    }

    public void put( int key, int value )
    {
        if ( map.size() < capacity )
        {
            if ( map.containsKey( key ) )
            {
                map.remove( key );
                map.put( key, value );
            }
            else
            {
                map.put( key, value );

            }
        }
        else
        {
            if ( map.containsKey( key ) )
            {
                map.remove( key );
                map.put( key, value );
            }
            else
            {
                int first = 0;

                for ( int k : map.keySet() )
                {
                    first = k;
                    break;
                }

                map.remove( first );
                map.put( key, value );
            }

        }
    }
}