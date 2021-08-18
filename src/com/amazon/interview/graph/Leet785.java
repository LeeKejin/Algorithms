package com.amazon.interview.graph;

public class Leet785
{
    class UnionClass
    {
        int parent[];

        public UnionClass( int n )
        {
            parent = new int[ n ];
            for ( int i = 0; i < n; i++ )
            {
                parent[ i ] = i;
            }
        }

        void merge( int x, int y )
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

    public boolean isBipartite( int[][] graph )
    {
        UnionClass unionClass = new UnionClass( graph.length );

        for ( int i = 0; i < graph.length; i++ )
        {
            for ( int j = 0; j < graph[ i ].length; j++ )
            {
                if ( unionClass.isConnected( i, graph[ i ][ j ] ) ) return false;
                unionClass.merge( graph[ i ][ j ], graph[ i ][ 0 ] );
            }
        }
        return true;
    }
}
