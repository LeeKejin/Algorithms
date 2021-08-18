package com.amazon.interview.graph;

import java.util.Arrays;

public class Leet803
{
    class UnionClass
    {
        int[] parent;
        int size[];

        public UnionClass( int n )
        {
            parent = new int[ n ];
            size = new int[ n ];
            for ( int i = 0; i < n; i++ )
            {
                parent[ i ] = i;
                size[ i ] = 1;
            }
        }

        public void merge( int x, int y )
        {
            int rootX = find( x );
            int rootY = find( y );
            if ( rootX != rootY )
            {
                parent[ rootX ] = rootY;
                size[ rootY ] += size[ rootX ];
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

        public int getSize( int x )
        {
            int root = find( x );
            return size[ root ];
        }
    }

    public static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public int[] hitBricks( int[][] grid, int[][] hits )
    {
        int m = grid.length;
        int n = grid[ 0 ].length;
        int size = m * n;
        UnionClass unionClass = new UnionClass( size + 1 );
        int[][] copy = new int[ m ][ n ];
        for ( int i = 0; i < m; i++ )
        {
            copy[ i ] = Arrays.copyOf( grid[ i ], n );
        }
        for ( int[] hit : hits )
        {
            int x = hit[ 0 ];
            int y = hit[ 1 ];
            copy[ x ][ y ] = 0;
        }

        for ( int i = 0; i < n; i++ )
        {
            if ( copy[ 0 ][ i ] == 1 )
            {
                unionClass.merge( getIndex( 0, i, n ), size );
            }
        }
        for ( int i = 1; i < m; i++ )
        {
            for ( int j = 0; j < n; j++ )
            {
                if ( copy[ i ][ j ] == 1 )
                {
                    if ( copy[ i - 1 ][ j ] == 1 )
                    {
                        unionClass.merge( getIndex( i - 1, j, n ), getIndex( i, j, n ) );
                    }
                    if ( j >= 1 && copy[ i ][ j - 1 ] == 1 )
                    {
                        unionClass.merge( getIndex( i, j, n ), getIndex( i, j - 1, n ) );
                    }
                }
            }
        }
        int[] res = new int[ hits.length ];
        for ( int i = hits.length - 1; i >= 0; i-- )
        {
            int x = hits[ i ][ 0 ];
            int y = hits[ i ][ 1 ];
            if ( grid[ x ][ y ] == 0 ) continue;
            int origin = unionClass.getSize( size );
            if ( x == 0 ) unionClass.merge( y, size );
            for ( int[] direction : DIRECTIONS )
            {
                int newX = x + direction[ 0 ];
                int newY = y + direction[ 1 ];
                if ( inArea( newX, newY, m, n ) && copy[ newX ][ newY ] == 1 )
                {
                    unionClass.merge( getIndex( x, y, n ), getIndex( newX, newY, n ) );
                }

            }
            int cur = unionClass.getSize( size );
            res[ i ] = Math.max( 0, cur - origin - 1 );

            // 真正补上这个砖块
            copy[ x ][ y ] = 1;

        }
        return res;
    }

    private boolean inArea( int x, int y, int m, int n )
    {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public int getIndex( int i, int j, int n )
    {
        return i * n + j;
    }
}
