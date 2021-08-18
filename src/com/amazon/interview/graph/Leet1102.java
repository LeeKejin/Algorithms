package com.amazon.interview.graph;

import java.util.PriorityQueue;

public class Leet1102
{
    class UnionClass
    {
        int[] parent;

        public UnionClass( int n )
        {
            parent = new int[ n ];
            for ( int i = 0; i < n; i++ )
            {
                parent[ i ] = i;
            }
        }

        public void merge( int x, int y )
        {
            int rootX = find( x );
            int rootY = find( y );
            if ( rootX != rootY )
            {
                parent[ rootX ] = rootY;
            }
        }

        private int find( int x )
        {
            if ( x != parent[ x ] )
            {
                parent[ x ] = find( parent[ x ] );
            }
            return parent[ x ];
        }

        boolean isConnected( int x, int y )
        {
            return find( x ) == find( y );
        }
    }

    public int maximumMinimumPath( int[][] grid )
    {
        PriorityQueue< int[] > queue = new PriorityQueue<>( ( a, b ) -> b[ 0 ] - a[ 0 ] );
        int n = grid[ 0 ].length;
        int m = grid.length;
        boolean visited[][] = new boolean[ m ][ n ];
        for ( int i = 0; i < grid.length; i++ )
        {
            for ( int j = 0; j < grid[ 0 ].length; j++ )
            {
                queue.add( new int[] { grid[ i ][ j ], i, j } );
            }
        }
        int res = Integer.MAX_VALUE;
        int start = 0;
        int end = m * n - 1;
        UnionClass unionClass = new UnionClass( m * n );
        int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        while ( !unionClass.isConnected( start, end ) )
        {
            int[] val = queue.poll();
            int x = val[ 1 ];
            int y = val[ 2 ];
            visited[ x ][ y ] = true;
            int index = x * n + y;
            for ( int[] dir : directions )
            {
                int newX = x + dir[ 0 ];
                int newY = y + dir[ 1 ];

                if ( inArea( newX, newY, m, n ) && visited[ newX ][ newY ] )
                {
                    int newIndex = newX * n + newY;
                    unionClass.merge( index, newIndex );
                    res = Math.min( val[ 0 ], res );
                }
            }
        }
        return res;
    }

    private boolean inArea( int x, int y, int m, int n )
    {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
