package com.amazon.interview.graph;

import java.util.ArrayList;
import java.util.List;

public class Leet261
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

    public boolean validTree( int n, int[][] edges )
    {
        if ( n != edges.length + 1 ) return false;
        UnionClass unionClass = new UnionClass( n );
        for ( int[] edge : edges )
        {
            if ( unionClass.isConnected( edge[ 0 ], edge[ 1 ] ) ) return false;
            unionClass.merge( edge[ 0 ], edge[ 1 ] );
        }
        return true;
    }

    public boolean validTreeUnionClass( int n, int[][] edges )
    {
        if ( n == 0 ) return false;
        if ( edges.length != n - 1 ) return false;
        List< List< Integer > > list = new ArrayList<>();
        boolean[] visited = new boolean[ n ];

        for ( int i = 0; i < n; i++ )
        {
            list.add( new ArrayList<>() );
        }
        for ( int[] edge : edges )
        {
            list.get( edge[ 0 ] ).add( edge[ 1 ] );
            list.get( edge[ 1 ] ).add( edge[ 0 ] );
        }
        dfs( 0, list, visited );
        for ( boolean v : visited )
        {
            if ( !v ) return false;
        }
        return true;
    }

    private void dfs( int i, List< List< Integer > > list, boolean[] visited )
    {
        if ( visited[ i ] ) return;
        visited[ i ] = true;
        for ( int p : list.get( i ) )
        {
            dfs( p, list, visited );
        }
    }
}
