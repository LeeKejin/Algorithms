package com.amazon.interview.graph;

public class Leet1319
{
    class UnionClass
    {
        int[] parents;

        public UnionClass( int n )
        {
            parents = new int[ n ];
            for ( int i = 0; i < n; i++ )
            {
                parents[ i ] = i;
            }
        }

        public void merge( int x, int y )
        {
            int rootX = find( x );
            int rootY = find( y );
            if ( rootX != rootY )
            {
                parents[ rootX ] = rootY;
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

        public boolean isConnected( int x, int y )
        {
            return find( x ) == find( y );
        }
    }

    public int makeConnected( int n, int[][] connections )
    {
        if ( connections.length < n - 1 ) return -1;
        UnionClass unionClass = new UnionClass( n );
        for ( int[] connect : connections )
        {
            if ( !unionClass.isConnected( connect[ 0 ], connect[ 1 ] ) )
            {
                unionClass.merge( connect[ 0 ], connect[ 1 ] );
            }
        }
        int count = 0;
        for ( int i = 1; i < n; i++ )
        {
            if ( unionClass.isConnected( i - 1, i ) ) continue;
            count++;
            unionClass.merge( i - 1, i );
        }
        return count;
    }
}
