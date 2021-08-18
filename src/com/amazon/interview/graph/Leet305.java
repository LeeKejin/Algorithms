package com.amazon.interview.graph;

import java.util.ArrayList;
import java.util.List;

public class Leet305
{
    class Solution
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

            public boolean isConnected( int x, int y )
            {
                return find( x ) == find( y );
            }
        }

        public List< Integer > numIslands2( int m, int n, int[][] positions )
        {
            if ( positions.length == 0 ) return new ArrayList<>();
            UnionClass unionClass = new UnionClass( m * n );
            int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
            int[][] grid = new int[ m ][ n ];
            //        boolean[][] visited = new boolean[ m ][ n ];
            List< Integer > res = new ArrayList<>();

            int count = 0;

            for ( int[] pos : positions )
            {
                int x = pos[ 0 ];
                int y = pos[ 1 ];
                int total = 0;
                if ( grid[ pos[ 0 ] ][ pos[ 1 ] ] == 1 )
                {
                    res.add( count );
                    continue;
                }
                count++;
                grid[ pos[ 0 ] ][ pos[ 1 ] ] = 1;
                //            visited[ x ][ y ] = true;
                for ( int[] direction : directions )
                {
                    int newX = x + direction[ 0 ];
                    int newY = y + direction[ 1 ];
                    if ( inArea( newX, newY, m, n ) && grid[ newX ][ newY ] == 1 && !unionClass
                        .isConnected( getIndex( x, y, n ), getIndex( newX, newY, n ) ) )
                    {
                        //                    visited[ newX ][ newY ] = true;
                        unionClass.merge( getIndex( x, y, n ), getIndex( newX, newY, n ) );
                        count--;
                    }

                }
                res.add( count );
            }
            return res;
        }

        public boolean inArea( int x, int y, int m, int n )
        {
            return x >= 0 && x < m && y >= 0 && y < n;
        }

        int getIndex( int x, int y, int n )
        {
            return x * n + y;
        }
    }
}
