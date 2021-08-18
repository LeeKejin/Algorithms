package com.amazon.interview.graph;

import java.util.HashMap;
import java.util.Map;

public class Leet947
{
    class UnionClass
    {
        Map< Integer, Integer > map = new HashMap<>();
        int count = 0;

        public void add( int x )
        {
            if ( !map.containsKey( x ) )
            {
                map.put( x, null );
                count++;
            }
        }

        public void merge( int x, int y )
        {
            int rootX = find( x );
            int rootY = find( y );
            if ( rootX != rootY )
            {
                map.put( rootX, rootY );
                count--;
            }
        }

        private int find( int x )
        {
            int root = x;
            while ( map.get( root ) != null )
            {
                root = map.get( root );
            }

            while ( x != root )
            {
                int origin = map.get( x );
                map.put( x, root );
                x = origin;
            }

            return root;
        }
    }

    public int removeStones( int[][] stones )
    {
        int size = stones.length;
        int count = stones.length;
        UnionClass unionClass = new UnionClass();
        for ( int[] stone : stones )
        {
            unionClass.add( stone[ 0 ] + 10001 );
            unionClass.add( stone[ 1 ] );
            unionClass.merge( stone[ 0 ] + 10001, stone[ 1 ] );
        }
        return count - unionClass.count;
    }
}
