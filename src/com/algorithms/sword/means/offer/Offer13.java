package com.algorithms.sword.means.offer;

public class Offer13
{
    int count = 0;

    public int movingCount( int m, int n, int k )
    {
        boolean[][] visited = new boolean[ m ][ n ];
        dfs( 0, 0, m, n, k, visited );
        return count;
    }

    private void dfs( int i, int j, int m, int n, int k, boolean[][] visited )
    {
        if ( i < 0 || i >= m || j < 0 || j >= n || visited[ i ][ j ] ) return;
        int i1 = i / 10;
        int i2 = i % 10;
        int j1 = j / 10;
        int j2 = j % 10;
        if ( i1 + i2 + j1 + j2 <= k )
        {
            visited[ i ][ j ] = true;
            count++;
            dfs( i - 1, j, m, n, k, visited );
            dfs( i + 1, j, m, n, k, visited );
            dfs( i, j - 1, m, n, k, visited );
            dfs( i, j + 1, m, n, k, visited );
        }
    }
}
