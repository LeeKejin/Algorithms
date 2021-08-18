package com.amazon.interview.graph;

public class Leet959
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

        public boolean merge( int x, int y )
        {
            int rootX = find( x );
            int rootY = find( y );
            if ( rootX != rootY )
            {
                parents[ rootX ] = rootY;
                return true;
            }
            return false;
        }

        private int find( int x )
        {
            if ( x != parents[ x ] )
            {
                parents[ x ] = find( parents[ x ] );
            }
            return parents[ x ];
        }
    }

    public int regionsBySlashes( String[] grid )
    {
        int m = grid.length;
        int n = m + 1;
        UnionClass unionClass = new UnionClass( n * n );
        for ( int i = 0; i < n; i++ )
        {
            for ( int j = 0; j < n; j++ )
            {
                if ( i == 0 || i == n - 1 || j == 0 || j == n - 1 )
                {
                    unionClass.merge( i * n + j, n * n - 1 );
                }
            }
        }
        int count = 1;
        for ( int i = 0; i < m; i++ )
        {
            String str = grid[ i ];
            for ( int j = 0; j < m; j++ )
            {
                int topLeft = i * n + j;
                int top;
                int button;
                if ( str.charAt( j ) == '/' )
                {
                    top = topLeft + 1;
                    button = topLeft + n;
                }
                else if ( str.charAt( j ) == '\\' )
                {
                    top = topLeft;
                    button = topLeft + n + 1;
                }
                else
                {
                    continue;
                }
                if ( !unionClass.merge( top, button ) )
                {
                    count++;
                }
            }
        }
        return count;
    }
}
