package com.amazon.interview;

import java.util.PriorityQueue;

public class Leet407
{
    public int trapRainWater( int[][] heightMap )
    {
        if ( heightMap == null || heightMap.length == 1 ) return 0;
        int n = heightMap.length;
        int m = heightMap[ 0 ].length;
        boolean vis[][] = new boolean[ n ][ m ];
        PriorityQueue< int[] > pq = new PriorityQueue<>( ( o1, o2 ) -> o1[ 2 ] - o2[ 2 ] );

        for ( int i = 0; i < n; i++ )
        {
            for ( int j = 0; j < m; j++ )
            {
                if ( i == 0 || i == n - 1 || j == 0 || j == m - 1 )
                {
                    pq.add( new int[] { i, j, heightMap[ i ][ j ] } );
                    vis[ i ][ j ] = true;
                }
            }
        }
        int res = 0;
        // 方向数组，把dx和dy压缩成一维来做
        int[] dirs = { 0, 1, 0, -1, 0 };
        while ( !pq.isEmpty() )
        {
            int[] poll = pq.poll();
            for ( int k = 0; k < 4; k++ )
            {

                int nx = poll[ 0 ] + dirs[ k ];
                int ny = poll[ 1 ] + dirs[ k + 1 ];
                if ( nx >= 0 && nx < n && ny >= 0 && ny < m && !vis[ nx ][ ny ] )
                {
                    if ( poll[ 2 ] > heightMap[ nx ][ ny ] )
                    {
                        res += ( poll[ 2 ] - heightMap[ nx ][ ny ] );
                    }
                    int h = Math.max( heightMap[ nx ][ ny ], poll[ 2 ] );
                    vis[ nx ][ ny ] = true;
                    pq.add( new int[] { nx, ny, h } );
                }
            }
        }
        return res;

    }
}
