package com.amazon.interview.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Leet1631
{
    class UnionClass
    {
        int[] parents;
        int[] abs;

        public UnionClass( int n )
        {
            parents = new int[ n ];
            abs = new int[ n ];
            for ( int i = 0; i < n; i++ )
            {
                parents[ i ] = i;
                abs[ i ] = -1;
            }
        }

        public void merge( int x, int y )
        {
            int rootX = find( x );
            int rootY = find( y );
            if ( rootX != rootY )
            {
                parents[ rootX ] = rootY;
                abs[ rootY ] = Math.max( abs[ rootY ], Math.abs( x - y ) );
            }
        }

        private int find( int x )
        {
            if ( x != parents[ x ] )
            {
                parents[ x ] = find( parents[ x ] );
            }
            return parents[ x ];
        }

        boolean isConnected( int x, int y )
        {
            return find( x ) == find( y );
        }
    }

    public int minimumEffortPath( int[][] heights )
    {
        int m = heights.length;
        int n = heights[ 0 ].length;
        UnionClass unionClass = new UnionClass( m * n );
        List< int[] > edge = new ArrayList<>();

        for ( int i = 0; i < heights.length; i++ )
        {
            for ( int j = 0; j < heights[ 0 ].length; j++ )
            {
                int index = getIndex( i, j, n );
                if ( i - 1 >= 0 )
                {
                    int up = getIndex( i - 1, j, n );
                    edge.add( new int[] { index, up, Math.abs( heights[ i ][ j ] - heights[ i - 1 ][ j ] ) } );
                }
                if ( j - 1 >= 0 )
                {
                    int left = getIndex( i, j - 1, n );
                    edge.add( new int[] { index, left, Math.abs( heights[ i ][ j ] - heights[ i ][ j - 1 ] ) } );
                }
            }
        }
        if ( edge.isEmpty() ) return 0;
        Collections.sort( edge, new Comparator< int[] >()
        {
            @Override
            public int compare( int[] o1, int[] o2 )
            {
                return o1[ 2 ] - o2[ 2 ];
            }
        } );
        int start = 0;
        int end = m * n - 1;
        for ( int[] point : edge )
        {
            unionClass.merge( point[ 0 ], point[ 1 ] );
            if ( unionClass.isConnected( start, end ) ) return point[ 2 ];
        }
        return -1;
    }

    int getIndex( int i, int j, int n )
    {
        return i * n + j;
    }
}
