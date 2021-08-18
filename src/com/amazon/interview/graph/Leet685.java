package com.amazon.interview.graph;

public class Leet685
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

        public boolean isConnected( int x, int y )
        {
            return find( x ) == find( y );
        }
    }

    public int[] findRedundantDirectedConnection( int[][] edges )
    {
        int[] inDegree = new int[ edges.length + 1 ];
        for ( int[] edge : edges )
        {
            inDegree[ edge[ 1 ] ]++;
        }
        for ( int i = edges.length - 1; i >= 0; i-- )
        {
            if ( inDegree[ edges[ i ][ 1 ] ] == 2 )
            {
                if ( !isCycle( i, edges ) )
                {
                    return edges[ i ];
                }
            }
        }
        for ( int i = edges.length - 1; i >= 0; i-- )
        {
            if ( inDegree[ edges[ i ][ 1 ] ] == 1 )
            {
                if ( !isCycle( i, edges ) )
                {
                    return edges[ i ];
                }
            }
        }
        return new int[] {};
    }

    private boolean isCycle( int index, int[][] edges )
    {
        UnionClass unionClass = new UnionClass( edges.length + 1 );

        for ( int i = 0; i < edges.length; i++ )
        {
            if ( i == index ) continue;
            if ( unionClass.isConnected( edges[ i ][ 0 ], edges[ i ][ 1 ] ) ) return true;
            unionClass.merge( edges[ i ][ 0 ], edges[ i ][ 1 ] );
        }
        return false;
    }

}

