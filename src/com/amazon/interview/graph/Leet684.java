package com.amazon.interview.graph;

public class Leet684
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

        boolean merge( int x, int y )
        {
            int rootX = find( x );
            int rootY = find( y );
            if ( rootX != rootY )
            {
                parent[ rootX ] = rootY;
                return true;
            }
            return false;
        }

        private int find( int x )
        {
            if ( parent[ x ] != x )
            {
                parent[ x ] = find( parent[ x ] );
            }
            return parent[ x ];
        }

    }

    public int[] findRedundantConnection( int[][] edges )
    {
        UnionClass unionClass = new UnionClass( edges.length * 2 );
        for ( int[] edge : edges )
        {
            if ( !unionClass.merge( edge[ 0 ], edge[ 1 ] ) )
            {
                return edge;
            }
        }
        return new int[] {};
    }
}
